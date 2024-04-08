package com.example.movieapplication;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private int release_year;
    private String genre1;
    private String genre2;
    private String genre3;
    private int running_time;
    private String production_company;
    private int budget;
    private int revenue;
    private static final long serialVersionUID = 1234567891;
    Movie(String name, int release_year, String genre1, String genre2, String genre3, int running_time, String production_company, int budget, int revenue)
    {
        this.name = name;
        this.release_year = release_year;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.running_time = running_time;
        this.production_company = production_company;
        this.budget = budget;
        this.revenue = revenue;
    }
    public String getName()
    {
        return name;
    }
    public int getRelease_year()
    {
        return release_year;
    }
    public String getGenre1()
    {
        return genre1;
    }
    public String getGenre2()
    {
        return genre2;
    }
    public String getGenre3()
    {
        return genre3;
    }
    public int getRunning_time()
    {
        return running_time;
    }
    public String getProduction_company()
    {
        return production_company;
    }
    public int getBudget()
    {
        return budget;
    }
    public int getRevenue()
    {
        return revenue;
    }
    public int getProfit()
    {
        return revenue - budget;
    }
    public int getLoss()
    {
        return budget - revenue;
    }
    public void print()
    {
        System.out.println("Title: " + name + ", Release Year: " + release_year + ", Genre1: " + genre1 + ", Genre2: " + genre2 + ", Genre3: " + genre3 + ", Running Time: " + running_time + ", Budget: " + budget + ", Revenue: " + revenue);
    }
    public String get_info_of_movie()
    {
        return (name + "," + release_year + "," + genre1 + "," + genre2 + "," + genre3 + "," + running_time + "," + production_company + "," + budget + "," + revenue );
    }
}
