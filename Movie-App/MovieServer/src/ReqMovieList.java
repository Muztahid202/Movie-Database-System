import com.example.movieapplication.Movie;
import java.util.List;

public class ReqMovieList {
    public static String companyName;

    static List<Movie> requiredMovieList()
    {
        List<Movie> showMovieList = SearchClass.search_movie_by_production_company(companyName);
        return showMovieList;
    }
}
