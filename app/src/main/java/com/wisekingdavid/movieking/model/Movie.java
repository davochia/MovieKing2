package com.wisekingdavid.movieking.model;

import java.util.List;

public class Movie {

    private int id;
    private String imdb_id;
    private String backdrop_path;
    private List<Genres> genres;
    private String original_title;
    private String overview;
    private String poster_path;
    private String release_date;
    private String title;
    private double vote_average;

    public Movie() {
    }

    public Movie(int id, String imdb_id, String backdrop_path, List<Genres> genres, String original_title, String overview, String poster_path, String release_date, String title, double vote_average) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.backdrop_path = backdrop_path;
        this.genres = genres;
        this.original_title = original_title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.title = title;
        this.vote_average = vote_average;
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

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", genres=" + genres +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", title='" + title + '\'' +
                ", vote_average=" + vote_average +
                '}';
    }
}
