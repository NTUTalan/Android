package com.example.a109590015_hw10_2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class Loader extends AsyncTaskLoader<String> {

    private String queryString;
    private String pickType;
    Context mContext;

    public Loader(@NonNull Context context, String s1, String s2) {
        super(context);
        queryString = s1;
        pickType = s2;
        mContext = context;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getSourceCode(mContext, queryString, pickType);
    }

    @Override
    public void onStartLoading() {
        forceLoad();
    }

}
