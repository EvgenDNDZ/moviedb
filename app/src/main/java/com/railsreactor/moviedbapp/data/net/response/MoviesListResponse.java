package com.railsreactor.moviedbapp.data.net.response;

import com.google.gson.annotations.SerializedName;
import com.railsreactor.moviedbapp.domain.models.Movie;

import java.util.List;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MoviesListResponse{

	@SerializedName("dates") private Dates dates;

	@SerializedName("page")	private int page;

	@SerializedName("total_pages")	private int totalPages;

	@SerializedName("results")	private List<Movie> results;

	@SerializedName("total_results") private int totalResults;

	public void setDates(Dates dates){
		this.dates = dates;
	}

	public Dates getDates(){
		return dates;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<Movie> results){
		this.results = results;
	}

	public List<Movie> getResults(){
		return results;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}
}