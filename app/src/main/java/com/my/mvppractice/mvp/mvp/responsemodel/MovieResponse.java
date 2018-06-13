package com.my.mvppractice.mvp.mvp.responsemodel;

import com.google.gson.annotations.SerializedName;
import com.my.mvppractice.mvp.restclient.RetroBaseResponse;

import java.util.List;

/**
 * Created by M1030452 on 8/14/2017.
 */

public class MovieResponse extends RetroBaseResponse{
    @SerializedName("results")
    private List<Movie> results;
    @SerializedName("page")
    private String page;
    @SerializedName("total_pages")
    private String total_pages;
    @SerializedName("total_results")
    private String total_results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + ", page = " + page + ", total_pages = " + total_pages + ", total_results = " + total_results + "]";
    }
}
