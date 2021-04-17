package com.wisekingdavid.movieking.model;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {

    protected abstract int getLayout();

    protected abstract void initLayout();

    protected abstract void runOperations();

    protected abstract void stopOperations();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initLayout();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        runOperations();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopOperations();
    }
}