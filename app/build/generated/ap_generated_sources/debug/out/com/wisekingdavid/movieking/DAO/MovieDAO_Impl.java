package com.wisekingdavid.movieking.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wisekingdavid.movieking.model.Cast;
import com.wisekingdavid.movieking.model.DataConverter;
import com.wisekingdavid.movieking.model.Movie;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDAO_Impl implements MovieDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movie> __insertionAdapterOfMovie;

  private final DataConverter __dataConverter = new DataConverter();

  private final EntityDeletionOrUpdateAdapter<Movie> __deletionAdapterOfMovie;

  public MovieDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Movie` (`id`,`imdb_id`,`backdrop_path`,`cast`,`original_title`,`overview`,`poster_path`,`release_date`,`title`,`vote_average`,`favourite`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
        if (value.getImdb_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImdb_id());
        }
        if (value.getBackdrop_path() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBackdrop_path());
        }
        final String _tmp;
        _tmp = __dataConverter.fromCastList(value.getCast());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getOriginal_title() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOriginal_title());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOverview());
        }
        if (value.getPoster_path() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPoster_path());
        }
        if (value.getRelease_date() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRelease_date());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTitle());
        }
        stmt.bindDouble(10, value.getVote_average());
        final int _tmp_1;
        _tmp_1 = value.isFavourite() ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
      }
    };
    this.__deletionAdapterOfMovie = new EntityDeletionOrUpdateAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Movie` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insertMovie(final Movie... movie) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Movie movie) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMovie.handle(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Movie> getAllMovies() {
    final String _sql = "SELECT * FROM movie";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfImdbId = CursorUtil.getColumnIndexOrThrow(_cursor, "imdb_id");
      final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdrop_path");
      final int _cursorIndexOfCast = CursorUtil.getColumnIndexOrThrow(_cursor, "cast");
      final int _cursorIndexOfOriginalTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "original_title");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_path");
      final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "release_date");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "vote_average");
      final int _cursorIndexOfFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
      final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Movie _item;
        _item = new Movie();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpImdb_id;
        if (_cursor.isNull(_cursorIndexOfImdbId)) {
          _tmpImdb_id = null;
        } else {
          _tmpImdb_id = _cursor.getString(_cursorIndexOfImdbId);
        }
        _item.setImdb_id(_tmpImdb_id);
        final String _tmpBackdrop_path;
        if (_cursor.isNull(_cursorIndexOfBackdropPath)) {
          _tmpBackdrop_path = null;
        } else {
          _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
        }
        _item.setBackdrop_path(_tmpBackdrop_path);
        final List<Cast> _tmpCast;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfCast)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfCast);
        }
        _tmpCast = __dataConverter.toCastList(_tmp);
        _item.setCast(_tmpCast);
        final String _tmpOriginal_title;
        if (_cursor.isNull(_cursorIndexOfOriginalTitle)) {
          _tmpOriginal_title = null;
        } else {
          _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
        }
        _item.setOriginal_title(_tmpOriginal_title);
        final String _tmpOverview;
        if (_cursor.isNull(_cursorIndexOfOverview)) {
          _tmpOverview = null;
        } else {
          _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        }
        _item.setOverview(_tmpOverview);
        final String _tmpPoster_path;
        if (_cursor.isNull(_cursorIndexOfPosterPath)) {
          _tmpPoster_path = null;
        } else {
          _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
        }
        _item.setPoster_path(_tmpPoster_path);
        final String _tmpRelease_date;
        if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
          _tmpRelease_date = null;
        } else {
          _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
        }
        _item.setRelease_date(_tmpRelease_date);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        final double _tmpVote_average;
        _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
        _item.setVote_average(_tmpVote_average);
        final boolean _tmpFavourite;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfFavourite);
        _tmpFavourite = _tmp_1 != 0;
        _item.setFavourite(_tmpFavourite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
