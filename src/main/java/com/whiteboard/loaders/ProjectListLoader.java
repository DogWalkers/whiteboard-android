package com.whiteboard.loaders;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.whiteboard.models.Project;

import java.util.List;

/**
 * Created by Sahil Jain on 08/06/2014.
 */
public class ProjectListLoader extends BaseNetworkLoader<List<Project>> {

    public ProjectListLoader(Context context) {
        super(context, "http://www.uwwhiteboard.com/api/projects", new TypeToken<List<Project>>(){}.getType());
    }
}
