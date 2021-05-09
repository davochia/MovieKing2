package com.wisekingdavid.movieking.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.wisekingdavid.movieking.model.Movie;

import java.util.List;
@Dao
public interface MovieDAO {
    @Query("SELECT * FROM movie")
    List<Movie> getAllMovies();

    @Insert
    void insertMovie(Movie... movie);

    @Delete
    void delete(Movie movie);
}
