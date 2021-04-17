package com.wisekingdavid.movieking.DataService;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.wisekingdavid.movieking.VolleySingleton;
import com.wisekingdavid.movieking.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieDataService {

    public static final String IMAGE_URI = "https://image.tmdb.org/t/p/w500"; // Image uri

    public static final String LATEST_MOVIES ="https://api.themoviedb.org/3/movie/latest?api_key=c1c68db8f902d5b4cd68ba02816b02ef&language=en-US";
    public static final String POPULAR_MOVIES ="https://api.themoviedb.org/3/movie/popular?api_key=c1c68db8f902d5b4cd68ba02816b02ef&language=en-US&page=1";
    public static final String NOW_PLAYING = "https://api.themoviedb.org/3/movie/now_playing?api_key=c1c68db8f902d5b4cd68ba02816b02ef&language=en-US&page=1";
    public static final String SEARCH_MOVIES ="https://api.themoviedb.org/3/search/movie?api_key=c1c68db8f902d5b4cd68ba02816b02ef&language=en-US&query=";

    Context context;


    public MovieDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(List<Movie> movieList);
    }


    // Get the first page of now playing movies from api
    public void getNowPlayingMovies(VolleyResponseListener volleyResponseListener){
        List<Movie> nowPlayingMovies = new ArrayList<>();

        String url = NOW_PLAYING;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray nowPlayingMovieList = response.getJSONArray("results");

                    for (int i = 0; i < nowPlayingMovieList.length(); i++){
                        Movie playingMovies = new Movie();

                        JSONObject firstMovieApi = (JSONObject) nowPlayingMovieList.get(i);

                        /// Popular movies added here
                        playingMovies.setBackdrop_path(IMAGE_URI + firstMovieApi.getString("backdrop_path"));
                        //popularMovies1.setGenre_ids((List<Genres>) firstMovieApi.getJSONArray("genre_ids"));
                        playingMovies.setId(firstMovieApi.getInt("id"));
                        playingMovies.setOverview(firstMovieApi.getString("overview"));
                        playingMovies.setPoster_path(IMAGE_URI + firstMovieApi.getString("poster_path"));
                        playingMovies.setRelease_date(firstMovieApi.getString("release_date"));
                        playingMovies.setTitle(firstMovieApi.getString("title"));
                        playingMovies.setVote_average(firstMovieApi.getDouble("vote_average"));

                        nowPlayingMovies.add(playingMovies);
                    }
                    volleyResponseListener.onResponse(nowPlayingMovies);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }


    // Get the first page of popular movies from api
    public void getPopularMovies(VolleyResponseListener volleyResponseListener){
        List<Movie> popularMovies = new ArrayList<>();
        String url = POPULAR_MOVIES;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray popularMovieList = response.getJSONArray("results");

                    for (int i = 0; i < popularMovieList.length(); i++){
                        Movie popularMovies1 = new Movie();

                        JSONObject firstMovieApi = (JSONObject) popularMovieList.get(i);

                        /// Popular movies added here
                        popularMovies1.setBackdrop_path(IMAGE_URI + firstMovieApi.getString("backdrop_path"));
                        //popularMovies1.setGenre_ids((List<Genres>) firstMovieApi.getJSONArray("genre_ids"));
                        popularMovies1.setId(firstMovieApi.getInt("id"));
                        popularMovies1.setOverview(firstMovieApi.getString("overview"));
                        popularMovies1.setPoster_path(IMAGE_URI + firstMovieApi.getString("poster_path"));
                        popularMovies1.setRelease_date(firstMovieApi.getString("release_date"));
                        popularMovies1.setTitle(firstMovieApi.getString("title"));
                        popularMovies1.setVote_average(firstMovieApi.getDouble("vote_average"));

                        popularMovies.add(popularMovies1);
                    }
                    volleyResponseListener.onResponse(popularMovies);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }


    public void getSearchMovies(String movieName, VolleyResponseListener searchResponseListener){
        List<Movie> searchMoviesArr = new ArrayList<>();
        String url = "";

        if(movieName.isEmpty()){
            url = SEARCH_MOVIES + "all";
        }
        else if(movieName.contains(" ")){
            String newMovieName = movieName.replace(" ", "+");
            url = SEARCH_MOVIES + newMovieName;
        }else {
            url = POPULAR_MOVIES;
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray searchMovieList = response.getJSONArray("results");
                    for (int i = 0; i < searchMovieList.length(); i++){
                        Movie searchedMovies = new Movie();
                        JSONObject firstMovieApi = (JSONObject) searchMovieList.get(i);

                        /// Search movies added here
                        searchedMovies.setBackdrop_path(IMAGE_URI + firstMovieApi.getString("backdrop_path"));
                        searchedMovies.setId(firstMovieApi.getInt("id"));
                        searchedMovies.setOverview(firstMovieApi.getString("overview"));
                        searchedMovies.setPoster_path(IMAGE_URI + firstMovieApi.getString("poster_path"));
                        searchedMovies.setRelease_date(firstMovieApi.getString("release_date"));
                        searchedMovies.setTitle(firstMovieApi.getString("title"));
                        searchedMovies.setVote_average(firstMovieApi.getDouble("vote_average"));
                        searchMoviesArr.add(searchedMovies);
                    }
                    searchResponseListener.onResponse(searchMoviesArr);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("COMM", error.toString());

                //Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();

//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
//                    }
//                }, 10000);
            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

}
