package com.wisekingdavid.movieking.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {
    @TypeConverter
    public String fromCastList(List<Cast> casts) {
        if (casts == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Cast>>() {
        }.getType();
        String json = gson.toJson(casts, type);
        return json;
    }

    @TypeConverter
    public List<Cast> toCastList(String casts) {
        if (casts == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Cast>>() {
        }.getType();
        List<Cast> castList = gson.fromJson(casts, type);
        return castList;
    }
}
