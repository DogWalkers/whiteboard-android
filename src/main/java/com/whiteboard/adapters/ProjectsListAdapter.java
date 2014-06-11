package com.whiteboard.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.whiteboard.R;
import com.whiteboard.models.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Sahil Jain on 08/06/2014.
 */
public class ProjectsListAdapter extends ArrayAdapter<Project> {

    private List<Project> items;
    Context context;
    int layoutResourceId;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            TextView tvTime = (TextView) convertView.findViewById(R.id.tvTimeCreated);
            tvTitle.setText(p.getTitle());
            tvCreator.setText(p.getCreator().get_id());
            tvDescription.setText(p.getDescription());
            tvPosition.setText(p.getPositionName());
            try {
                Date date = dateFormat.parse(p.getDateCreated().substring(0, 10));
                long epoch = date.getTime();
                tvTime.setText(DateUtils.getRelativeDateTimeString(context, epoch, DateUtils.DAY_IN_MILLIS, DateUtils.WEEK_IN_MILLIS, 0).toString().split(",")[0]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return convertView;
    }
}
