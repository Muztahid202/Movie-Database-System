import com.example.movieapplication.Movie;
import com.example.movieapplication.DataWrapper;
import com.example.movieapplication.CompanyObject;
import com.example.movieapplication.TransferMovieObject;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Server {
    static String productionCompanyName;
    static List<Movie> companyMovieList;
    public static void main(String[] args) throws Exception {
        //server open
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server Started...");
        MovieList movieDatabase = new MovieList();
        movieDatabase.readFile();

        HashMap<String,SocketWrapper> clientMap = new HashMap<>();

        while(true)
        {
            //accepting a client
            Socket clientSocket = serverSocket.accept();
            SocketWrapper client = new SocketWrapper(clientSocket);

            new Thread(()->{
                try {
                    while (true) {
                        Object data = client.read();

                        DataWrapper dw = (DataWrapper) data;


                        if (dw.number == 1) {
                            productionCompanyName = (String) dw.data;
                            clientMap.put(productionCompanyName.toUpperCase(),client);
                            System.out.println(productionCompanyName);
                            boolean flag = true;
                            //searching the company in list
                            for (String s : SearchClass.productionCompanyList()) {
                                if (productionCompanyName.equalsIgnoreCase(s)) {
                                    System.out.println("Yeeeeee Found the company");
                                    companyMovieList = SearchClass.search_movie_by_production_company(productionCompanyName);
                                    flag = false;
                                    client.write(new DataWrapper(1,new CompanyObject(companyMovieList,SearchClass.productionCompanyList())));
                                }
                            }
                            if(flag)
                            {
                                client.write(new DataWrapper(1,new CompanyObject(new ArrayList<>(),SearchClass.productionCompanyList())));
                            }
                        } else if (dw.number == 2){
                            Movie movie = (Movie) dw.data;
                            MovieList.movielist.add(movie);
                            client.write(new DataWrapper(2,companyMovieList));
                        } else if (dw.number == 3) {
                            TransferMovieObject transferMovieObject = (TransferMovieObject) dw.data;
                            companyMovieList = transferMovieObject.senderList;
                            Movie addingToReceiver = transferMovieObject.movie;
                            String receiverName = transferMovieObject.receiver;

                            for (Movie m : MovieList.movielist) {
                                if (m.getName().equalsIgnoreCase(addingToReceiver.getName())) {
                                    m.setProduction_company(receiverName);
                                    break;
                                }
                            }

                            SocketWrapper receiverClient = clientMap.get(receiverName.toUpperCase());
                            System.out.println("receiver client: " + receiverClient);
                            if(receiverClient != null)
                            {
                                System.out.println("sending to receiver");
                                List<Movie> receiverList = SearchClass.search_movie_by_production_company(receiverName);
                                receiverClient.write(new DataWrapper(3,receiverList));
                            }
                        }
                    }
                    } catch(IOException e){
                        System.out.println("Client is disconnected");
                    try {
                        FileWrite.writeFile();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } catch(ClassNotFoundException e){
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
