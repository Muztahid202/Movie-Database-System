package com.example.movieapplication;

import java.util.*;

public class SearchClass {
    List<Movie> search_movie_by_title(String name)
    {
        List<Movie>movieByTitle = new ArrayList<>();
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            Movie m = MovieList.movielist.get(i);
            if(m.getName().equalsIgnoreCase(name))
            {
                movieByTitle.add(m);
            }
        }
        return movieByTitle;
    }
    List<Movie> search_movie_by_release_year(int year)
    {
        List<Movie> movieByReleaseYear = new ArrayList<>();
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            Movie m = MovieList.movielist.get(i);
            if(m.getRelease_year() == year)
            {
                movieByReleaseYear.add(m);
            }
        }
        return movieByReleaseYear;
    }
    List<Movie> search_movie_by_genre(String gname)
    {
        List<Movie> movieByGenre = new ArrayList<>();
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            Movie m = MovieList.movielist.get(i);
            if(m.getGenre1().equalsIgnoreCase(gname))
            {
                movieByGenre.add(m);
            }
            if(m.getGenre2().equalsIgnoreCase(gname))
            {
                movieByGenre.add(m);
            }
            if(m.getGenre3().equalsIgnoreCase(gname))
            {
                movieByGenre.add(m);
            }
        }
        return movieByGenre;
    }
    static List<Movie> search_movie_by_production_company(String pro_company)
    {
        List<Movie> movieByProductionCompany = new ArrayList<>();
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            Movie m = MovieList.movielist.get(i);
            if(m.getProduction_company().equalsIgnoreCase(pro_company))
            {
                movieByProductionCompany.add(m);
            }
        }
        return movieByProductionCompany;
    }
     List<Movie> search_movie_by_running_time(int minruntime, int maxruntime)
    {
        List<Movie> movieByRunningTime = new ArrayList<>();
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            Movie m = MovieList.movielist.get(i);
            if(minruntime <= m.getRunning_time() && m.getRunning_time() <= maxruntime)
            {
                movieByRunningTime.add(m);
            }
        }
        return movieByRunningTime;
    }

    List<Movie> top10movies()
    {
        List<Movie> topTenMovies = new ArrayList<>();
        int[] profit_array = new int[MovieList.movielist.size()];
        for(int i = 0; i<MovieList.movielist.size(); i++)
        {
            Movie m = MovieList.movielist.get(i);
            if(m.getBudget()< m.getRevenue())
           {
                profit_array[i] = m.getProfit();
           }
        }
        Arrays.sort(profit_array);
        for(int j = profit_array.length-1; j>profit_array.length-11; j--)
        {

            for(int i = 0; i<MovieList.movielist.size(); i++)
            {
                Movie m = MovieList.movielist.get(i);
                if(profit_array[j] == m.getProfit())
                {
                    topTenMovies.add(m);
                }
            }
        }
         return topTenMovies;
    }
    Boolean existenceOfProductionCompany(String proCompany)
    {
        for(Movie m : MovieList.movielist)
        {
            if(m.getProduction_company().equalsIgnoreCase(proCompany))
            {
                return true;
            }
        }
        return false;
    }
      static List<Movie> search_recent_movie(List<Movie> productionCompanyMovieList)
    {
        List<Movie> recentMovie = new ArrayList<>();
        int latest_release_year = 0;
        for(Movie m : productionCompanyMovieList){
                if(m.getRelease_year()>latest_release_year) {
                    latest_release_year = m.getRelease_year();
                }
            }

       for(Movie m : productionCompanyMovieList){
                if (m.getRelease_year() == latest_release_year) {
                    recentMovie.add(m);
                }
            }
        return recentMovie;
    }

    static List<Movie> search_max_revenue(List<Movie> productionCompanyMovieList)
    {
        List<Movie> movieByMaxRev = new ArrayList<>();
        int max_revenue = 0;
       for(Movie m : productionCompanyMovieList){
                if(m.getRevenue() > max_revenue)
                {
                    max_revenue = m.getRevenue();
                }
            }

        for(Movie m : productionCompanyMovieList){
                if (m.getRevenue() == max_revenue) {
                    movieByMaxRev.add(m);
                }
            }
        return movieByMaxRev;
    }
    static long total_profit_company(List<Movie> productionCompanyMovieList)
    {
        long totalpro = 0;
        for(Movie m : productionCompanyMovieList){
                if(m.getBudget()<m.getRevenue())
                totalpro += m.getProfit();
                else{
                    totalpro -= m.getLoss();
                }
            }
            return totalpro;
    }
    void list_of_production_company() {
        int movie_count = 0;
        Set<String> production_company_list = new HashSet<>();
        for (int i = 0; i < MovieList.movielist.size(); i++) {
            Movie m = MovieList.movielist.get(i);
            production_company_list.add(m.getProduction_company());
        }
       for(String element : production_company_list)
       {
           for(int j = 0; j<MovieList.movielist.size(); j++)
           {
               Movie n = MovieList.movielist.get(j);
               if(element.equalsIgnoreCase(n.getProduction_company()))
               {
                   movie_count++;
               }
           }
           System.out.println("Production Company: " + element + ", Number of Movies: " + movie_count);
           movie_count = 0;
       }
    }
    static List<String> productionCompanyList()
    {
        Set<String> production_company_list = new HashSet<>();
       // System.out.println(MovieList.movielist.size());
        for (int i = 0; i < MovieList.movielist.size(); i++) {
            Movie m = MovieList.movielist.get(i);
            production_company_list.add(m.getProduction_company());
            //System.out.println(production_company_list.size());
        }
        List<String> listOfProductionCompany = new ArrayList<>(production_company_list);
       // System.out.println(production_company_list.size());
        return listOfProductionCompany;
    }
   /* static List<Movie> allMovieShow(List<Movie> productionCompanyMovieList)
    {
        List<Movie> processingMovieList = new ArrayList<>();
        for(Movie m : productionCompanyMovieList)
        {
            processingMovieList.add(m);
        }
        return processingMovieList;
    }*/
}
