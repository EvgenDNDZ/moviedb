package com.railsreactor.moviedbapp.data.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class PaginatedListResponse<T> {

    @SerializedName("results")
    private List<T> results;

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("dates")
    private Dates dates;

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Dates getDates() {
        return dates;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalResults() {
        return totalResults;
    }
}