package com.wisekingdavid.movieking.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.wisekingdavid.movieking.DAO.MovieDAO;
import com.wisekingdavid.movieking.model.DataConverter;
import com.wisekingdavid.movieking.model.Movie;

@Database(entities = {Movie.class}, version  = 1)
@TypeConverters(DataConverter.class)
public abstract class MovieDatabase extends RoomDatabase {
    private static final String DB_Name = "Movie_DB";

    public abstract MovieDAO movieDAO();

    private static MovieDatabase INSTANCE;

    public static MovieDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MovieDatabase.class, DB_Name)
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}
