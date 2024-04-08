import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.example.movieapplication.Movie;

class MovieList {
        static List<Movie> movielist = new ArrayList<>();

    void readFile() throws Exception{
            BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                String[] movie_details = line.split(",");
                String name = movie_details[0];
                int year = Integer.parseInt(movie_details[1]);
                String genre1 = movie_details[2];
                String genre2 = movie_details[3];
                String genre3 = movie_details[4];
                int runtime = Integer.parseInt(movie_details[5]);
                String production_company = movie_details[6];
                int budget = Integer.parseInt(movie_details[7]);
                int revenue = Integer.parseInt(movie_details[8]);
                Movie m = new Movie(name, year, genre1, genre2, genre3, runtime, production_company, budget, revenue);
                movielist.add(m);
                }

              br.close();

            }


}





