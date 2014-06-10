package com.whiteboard.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.whiteboard.R;
import com.whiteboard.activities.ViewProjectActivity;
import com.whiteboard.adapters.ProjectsListAdapter;
import com.whiteboard.loaders.ProjectListLoader;
import com.whiteboard.models.Project;

import java.util.List;

public class FragmentA extends ListFragment implements LoaderManager.LoaderCallbacks<List<Project>>, SwipeRefreshLayout.OnRefreshListener{

    SwipeRefreshLayout swipeLayout;
    List<Project> projects = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        swipeLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.swipe_container);
        swipeLayout.setColorScheme(R.color.swipe_color1, R.color.swipe_color2, R.color.swipe_color3, R.color.swipe_color4);
        swipeLayout.setOnRefreshListener(this);
        getLoaderManager().initLoader(1,null,this);
        Log.d("WHITEBOARD", "onActivityCreated");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), ViewProjectActivity.class);
        intent.putExtra("projectId", projects.get(position).get_id());
        startActivity(intent);
    }

    @Override
    public Loader<List<Project>> onCreateLoader(int id, Bundle args) {
        Log.d("WHITEBOARD", "onCreateLoader");
        return new ProjectListLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Project>> loader, List<Project> data) {
        Log.d("WHITEBOARD", "load finished");
        swipeLayout.setRefreshing(false);
        ProgressBar pb = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        pb.setVisibility(View.GONE);
        if(data != null){
        projects = data;
        ProjectsListAdapter listAdapter = new ProjectsListAdapter(getActivity(), R.layout.projects_list_item, data);
        setListAdapter(listAdapter);
        }else{
            Toast.makeText(getActivity(), "Could not refresh projects", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Project>> loader) {
        Log.d("WHITEBOARD", "load finished");
    }

    @Override
    public void onRefresh() {
        getLoaderManager().restartLoader(1,null,this);
    }
}
