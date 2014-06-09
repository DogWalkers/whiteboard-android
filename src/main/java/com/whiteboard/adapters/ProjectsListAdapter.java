package com.whiteboard.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.whiteboard.R;
import com.whiteboard.models.Project;

import java.util.List;

/**
 * Created by Sahil Jain on 08/06/2014.
 */
public class ProjectsListAdapter extends ArrayAdapter<Project> {

    private List<Project> items;
    Context context;
    int layoutResourceId;

    public ProjectsListAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.layoutResourceId = resource;
    }


    public ProjectsListAdapter(Context context, int resource, List<Project> data) {
        super(context, resource, data);
        this.items = data;
        this.context = context;
        this.layoutResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();//is that the right context?
            convertView = inflater.inflate(layoutResourceId, parent, false);//check why it's null
        }

        Project p = items.get(position);

        if(p != null){
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            TextView tvCreator = (TextView) convertView.findViewById(R.id.tvCreator);
            TextView tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            TextView tvPosition = (TextView) convertView.findViewById(R.id.tvPositionTitle);
            tvTitle.setText(p.getTitle());
            tvCreator.setText(p.getCreator().get_id());
            tvDescription.setText(p.getDescription());
            tvPosition.setText(p.getPositionName());
        }
        return convertView;
    }
}
