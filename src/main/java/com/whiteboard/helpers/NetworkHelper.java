package com.whiteboard.helpers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.whiteboard.models.Project;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Sahil Jain on 08/06/2014.
 */
public class NetworkHelper {

    public static InputStream getInputStreamFromUrl(String url) {
        Log.d("WHTITEBOARD", "getting input stream from url");
        InputStream stream = null;
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
        Log.d("WHTITEBOARD", "trying to GET");
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
        Log.d("WHTITEBOARD", "GET response recieved");
                HttpEntity entity = response.getEntity();
                stream = entity.getContent();

            } else {
                Log.e("WHITEBOARD", "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}