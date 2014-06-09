package com.whiteboard.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.whiteboard.R;
import com.whiteboard.adapters.ProjectsListAdapter;
import com.whiteboard.loaders.ProjectsLoader;
import com.whiteboard.models.Project;

import java.util.List;

public class FragmentA extends ListFragment implements LoaderManager.LoaderCallbacks<List<Project>>{

    String[] randoms = {"hello", "hello2", "hello3"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(1,null,this);
        Log.d("WHITEBOARD", "onActivityCreated");
    }

    @Override
    public Loader<List<Project>> onCreateLoader(int id, Bundle args) {
        Log.d("WHITEBOARD", "onCreateLoader");
        return new ProjectsLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Project>> loader, List<Project> data) {
        Log.d("WHITEBOARD", "load finished");
        ProgressBar pb = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        pb.setVisibility(View.GONE);
//        TextView tv = (TextView) getActivity().findViewById(R.id.text_1);
        if(data != null){
//            String out = "";
//            for(Project p : data){
//                out += p.getTitle() + "\n";
//            }
//            tv.setText(out);
//        } else {
//            tv.setText("couldn't refresh data");

        ProjectsListAdapter listAdapter = new ProjectsListAdapter(getActivity(), R.layout.projects_list_item, data);
        setListAdapter(listAdapter);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Project>> loader) {
        Log.d("WHITEBOARD", "load finished");
    }
}
