package com.example.movieapplication;

import java.io.Serializable;
import java.util.List;

public class TransferMovieObject implements Serializable {
    public List<Movie> senderList;
    public String receiver;
    public Movie movie;

    public TransferMovieObject(List<Movie> senderList,Movie movie,String receiver)
    {
        this.senderList = senderList;
        this.movie = movie;
        this.receiver = receiver;
    }
}
