package com.whiteboard.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.whiteboard.helpers.NetworkHelper;
import com.whiteboard.models.Project;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahil Jain on 08/06/2014.
 */
public class ProjectsLoader extends AsyncTaskLoader<List<Project>> {

    private List<Project> mData;

    public ProjectsLoader(Context context) {
        super(context);
    }

    @Override
    public List<Project> loadInBackground() {
        Log.d("WHITEBOARD", "load in background");
        List<Project> projects = retrieveProjects();
        mData = projects;
        return projects;
    }

    private List<Project> retrieveProjects() {
        List<Project> projects = null;
        InputStream stream = NetworkHelper.getInputStreamFromUrl("http://www.uwwhiteboard.com/api/projects");
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List<Project>>(){}.getType();
        if(stream != null) {
            projects = gson.fromJson(new InputStreamReader(stream), listType);
        }
        return projects;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.d("WHITEBOARD", "on start loading called");
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }

}
