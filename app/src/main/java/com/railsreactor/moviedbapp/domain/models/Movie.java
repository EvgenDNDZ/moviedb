package com.railsreactor.moviedbapp.domain.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.railsreactor.moviedbapp.BuildConfig;
import com.railsreactor.moviedbapp.utils.DateUtils;

import java.util.List;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class Movie extends BaseObservable {

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("genres")
    private List<Genre> genres;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("production_countries")
    private List<Country> productionCountries;

    @SerializedName("id")
    private int id;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("budget")
    private int budget;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("spoken_languages")
    private List<Language> spokenLanguages;

    @SerializedName("production_companies")
    private List<Company> productionCompanies;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("belongs_to_collection")
    private Object belongsToCollection;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("status")
    private String status;

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isVideo() {
        return video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath() {
        return BuildConfig.BASE_URL_IMG + backdropPath;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setProductionCountries(List<Country> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public List<Country> getProductionCountries() {
        return productionCountries;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setSpokenLanguages(List<Language> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<Language> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setProductionCompanies(List<Company> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<Company> getProductionCompanies() {
        return productionCompanies;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTagline() {
        return tagline;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Bindable
    public String getThumbnailImage() {
        return String.format("%s%s", BuildConfig.BASE_URL_THUMBNAIL_IMG, getPosterPath());
    }

    @Bindable
    public String getCombinedTitle() {
        return !TextUtils.equals(getTitle(), getOriginalTitle()) ? String.format("%s(%s)", getTitle(), getOriginalTitle()) : getTitle();
    }

    public String getBriefInfo() {
        return String.format("%s %s %s", getYear(), android.text.format.DateUtils.formatElapsedTime(runtime), getGenresCommaSeparated());
    }

    private String getYear() {
        return !TextUtils.isEmpty(getReleaseDate())
                ? DateUtils.getDateAsString(DateUtils.getDateFromString(getReleaseDate(), DateUtils.fullFormat), DateUtils.dateYear)
                : "";
    }

    private String getGenresCommaSeparated() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Genre item : getGenres()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(item.getName());
        }
        return stringBuilder.toString();
    }
}
