package com.example.movieapplication;

import java.util.ArrayList;
import java.util.List;

public class ReqMovieList {
    public static String companyName;

    static List<Movie> requiredMovieList()
    {
        List<Movie> showMovieList = SearchClass.search_movie_by_production_company(companyName);
        return showMovieList;
    }
    static List<String> movieNameList()
    {
        List<String> movieNameArray = new ArrayList<>();
        for(Movie m : MovieClient.companyMovieList)
        {
            movieNameArray.add(m.getName());
        }
        return movieNameArray;
    }
}
