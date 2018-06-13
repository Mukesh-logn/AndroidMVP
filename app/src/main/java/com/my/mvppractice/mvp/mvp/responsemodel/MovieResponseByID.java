package com.my.mvppractice.mvp.mvp.responsemodel;

import java.util.List;

/**
 * Created by M1030452 on 8/14/2017.
 */

public class MovieResponseByID {
    private String id;

    private List<MovieDetailByID> results;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public List<MovieDetailByID> getResults ()
    {
        return results;
    }

    public void setResults (List<MovieDetailByID> results)
    {
        this.results = results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", results = "+results+"]";
    }
}
