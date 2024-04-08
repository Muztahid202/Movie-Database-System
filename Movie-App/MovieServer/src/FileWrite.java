import java.io.BufferedWriter;
import java.io.FileWriter;

class FileWrite {
    static void writeFile() throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt"));
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            bw.write(MovieList.movielist.get(i).get_info_of_movie());
            bw.write(System.lineSeparator());
        }
       bw.close();
    }

}
