package com.whiteboard.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.whiteboard.helpers.NetworkHelper;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * Created by Sahil Jain on 09/06/2014.
 */
public class BaseNetworkLoader<D> extends AsyncTaskLoader<D> {

    private D data = null;//why do we need this reference?
    private String url;
    private Type type;

    public BaseNetworkLoader(Context context, String url, Type type) {
        super(context);
        this.url = url;
        this.type = type;
    }

    @Override
    public D loadInBackground() {
        Log.d("WHITEBOARD", "load in background");
        D dataRetrieved = retrieveDataFromNetwork(url);
        this.data = dataRetrieved;
        return dataRetrieved;
    }

    private D retrieveDataFromNetwork(String url) {
        D toReturn = null;
        InputStream stream = NetworkHelper.getInputStreamFromUrl(url);
        Gson gson = new GsonBuilder().create();
        if(stream != null) {
            toReturn = gson.fromJson(new InputStreamReader(stream), type);
        }
        return toReturn;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.d("WHITEBOARD", "on start loading called");
        forceLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
        data = null;
    }


}
