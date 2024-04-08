package com.example.movieapplication;

import java.io.Serializable;

public class DataWrapper implements Serializable {
    public Object data;
    public int number;

    public DataWrapper(int number, Object data)
    {
        this.data = data;
        this.number = number;
    }
}
