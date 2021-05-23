package com.wisekingdavid.movieking.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "imdb_id")
    private String imdb_id;

    @ColumnInfo(name = "backdrop_path")
    private String backdrop_path;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "cast")
    private List<Cast> cast;

    @ColumnInfo(name = "original_title")
    private String original_title;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "poster_path")
    private String poster_path;

    @ColumnInfo(name = "release_date")
    private String release_date;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "vote_average")
    private double vote_average;

    @ColumnInfo(name = "favourite")
    private boolean favourite;

    public Movie() {
    }

    public Movie(int id, String imdb_id, String backdrop_path, List<Cast> cast, String original_title, String overview, String poster_path, String release_date, String title, double vote_average, boolean favourite) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.backdrop_path = backdrop_path;
        this.cast = cast;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.title = title;
        this.vote_average = vote_average;
        this.favourite = favourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", cast=" + cast +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", title='" + title + '\'' +
                ", vote_average=" + vote_average +
                ", favourite=" + favourite +
                '}';
    }
}
