package com.example.movieapplication;

import java.io.Serializable;
import java.util.List;

public class CompanyObject implements Serializable {
    List<Movie> movieListObject;
    List<String> companyNameListSend;

    public CompanyObject(List<Movie> movieListObject, List<String>companyNameListSend)
    {
        this.movieListObject = movieListObject;
        this.companyNameListSend = companyNameListSend;
    }
}
