package com.example.movieapplication;

import javafx.application.Platform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MovieClient {
     static SocketWrapper connectedWithServer;
    static List<Movie> companyMovieList = new ArrayList<>();
    static List<String> companyNameList = new ArrayList<>();
    static List<Movie> receivedList = new ArrayList<>();
    public static void clientCreate(String userInput) throws IOException {
        connectedWithServer = new SocketWrapper("127.0.0.1", 3000);
        //sending the name which was input by the user
        connectedWithServer.write(new DataWrapper(1,userInput));

        new Thread(()-> {
            try
            {
                while (true) {
                    Object data = connectedWithServer.read();
                    DataWrapper dw = (DataWrapper) data;

                    if (dw.number == 1) {
                        CompanyObject companyObject = (CompanyObject) dw.data;
                        companyMovieList = companyObject.movieListObject;
                        companyNameList =  companyObject.companyNameListSend;
                        System.out.println(companyMovieList.size());
                        for (Movie m : companyMovieList) {
                            System.out.println(m.getName());
                        }

                        Platform.runLater(() -> {
                            try {
                                MovieApplication.logInController.respond(MovieApplication.stage);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    } else if (dw.number == 2) {
                        companyMovieList = (List<Movie>) dw.data;
                        for(Movie m : companyMovieList)
                        {
                            System.out.println(m.getName());
                        }
                    } else if (dw.number == 3) {
                        receivedList = (List<Movie>) dw.data;
                        System.out.println("here");
                        companyMovieList = receivedList;
                        MovieApplication.controller.refresh();
                        System.out.println("Transfer done");
                    }
                }
                } catch(IOException e)
            {
                System.out.println("Server disconnected");
            } catch(ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public static void clientWrite(Movie addedMovie) throws IOException {
            connectedWithServer.write(new DataWrapper(2, addedMovie));
    }
    public static void clientTransfer(List<Movie>senderList, Movie movie, String receiver) throws IOException {
        connectedWithServer.write(new DataWrapper(3,new TransferMovieObject(senderList,movie,receiver)));
    }


}

