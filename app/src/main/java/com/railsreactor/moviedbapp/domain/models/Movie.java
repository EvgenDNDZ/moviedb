package com.railsreactor.moviedbapp.domain.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class Movie implements Parcelable{
    @SerializedName("overview") private String overview;

    @SerializedName("original_language") private String originalLanguage;

    @SerializedName("original_title") private String originalTitle;

    @SerializedName("video") private boolean video;

    @SerializedName("title") private String title;

    @SerializedName("genre_ids") private List<Integer> genreIds;

    @SerializedName("poster_path") private String posterPath;

    @SerializedName("backdrop_path") private String backdropPath;

    @SerializedName("release_date")  private String releaseDate;

    @SerializedName("popularity") private double popularity;

    @SerializedName("vote_average") private double voteAverage;

    @SerializedName("id") private int id;

    @SerializedName("adult") private boolean adult;

    @SerializedName("vote_count") private int voteCount;

    protected Movie(Parcel in) {
        overview = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        video = in.readByte() != 0;
        title = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        releaseDate = in.readString();
        popularity = in.readDouble();
        voteAverage = in.readDouble();
        id = in.readInt();
        adult = in.readByte() != 0;
        voteCount = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public void setOverview(String overview){
        this.overview = overview;
    }

    public String getOverview(){
        return overview;
    }

    public void setOriginalLanguage(String originalLanguage){
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage(){
        return originalLanguage;
    }

    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle(){
        return originalTitle;
    }

    public void setVideo(boolean video){
        this.video = video;
    }

    public boolean isVideo(){
        return video;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setGenreIds(List<Integer> genreIds){
        this.genreIds = genreIds;
    }

    public List<Integer> getGenreIds(){
        return genreIds;
    }

    public void setPosterPath(String posterPath){
        this.posterPath = posterPath;
    }

    public String getPosterPath(){
        return posterPath;
    }

    public void setBackdropPath(String backdropPath){
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath(){
        return backdropPath;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setPopularity(double popularity){
        this.popularity = popularity;
    }

    public double getPopularity(){
        return popularity;
    }

    public void setVoteAverage(double voteAverage){
        this.voteAverage = voteAverage;
    }

    public double getVoteAverage(){
        return voteAverage;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setAdult(boolean adult){
        this.adult = adult;
    }

    public boolean isAdult(){
        return adult;
    }

    public void setVoteCount(int voteCount){
        this.voteCount = voteCount;
    }

    public int getVoteCount(){
        return voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(overview);
        parcel.writeString(originalLanguage);
        parcel.writeString(originalTitle);
        parcel.writeByte((byte) (video ? 1 : 0));
        parcel.writeString(title);
        parcel.writeString(posterPath);
        parcel.writeString(backdropPath);
        parcel.writeString(releaseDate);
        parcel.writeDouble(popularity);
        parcel.writeDouble(voteAverage);
        parcel.writeInt(id);
        parcel.writeByte((byte) (adult ? 1 : 0));
        parcel.writeInt(voteCount);
    }
}
