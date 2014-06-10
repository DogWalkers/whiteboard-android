package com.whiteboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.whiteboard.R;
import com.whiteboard.loaders.ProjectLoader;
import com.whiteboard.models.Project;

public class ViewProjectActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Project>{

    Project project = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_project);
        Intent intent = getIntent();
        String projectId = intent.getStringExtra("projectId");
        Bundle bundle = new Bundle();
        bundle.putString("projectId", projectId);
        getSupportLoaderManager().initLoader(2, bundle, this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_project, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Project> onCreateLoader(int id, Bundle args) {
        return new ProjectLoader(this, args.getString("projectId"));
    }

    @Override
    public void onLoadFinished(Loader<Project> loader, Project data) {
        //populate all the text accordingly, and kill the progress spinner
        project = data;

        if(project != null){
            TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
            TextView tvCreator = (TextView) findViewById(R.id.tvCreator);
            TextView tvDescription = (TextView) findViewById(R.id.tvDescription);
            TextView tvPosition = (TextView) findViewById(R.id.tvPositionTitle);
            tvTitle.setText(project.getTitle());
            tvCreator.setText(project.getCreator().get_id());
            tvDescription.setText(project.getDescription());
            tvPosition.setText(project.getPositionName());
        }
    }

    @Override
    public void onLoaderReset(Loader<Project> loader) {

    }
}
