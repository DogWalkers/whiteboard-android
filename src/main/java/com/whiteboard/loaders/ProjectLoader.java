package com.whiteboard.loaders;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.whiteboard.models.Project;

import java.util.List;

/**
 * Created by Sahil Jain on 09/06/2014.
 */
public class ProjectLoader extends BaseNetworkLoader<Project> {

    public ProjectLoader(Context context, String projectId) {
        super(context, "http://www.uwwhiteboard.com/api/project?id=" + projectId, new TypeToken<Project>(){}.getType());
    }
}
