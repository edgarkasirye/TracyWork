package com.example.NEMACOLLECT;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class NextActivityScreen6 extends AppCompatActivity {

    TextView txtBlank;
    TextView txtSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new6);


        Toolbar toolbar6 = (Toolbar) findViewById(R.id.toolbar6);

        setSupportActionBar(toolbar6);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_stay_current_portrait_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
// Get access to the custom title view
        TextView mTitle = (TextView) toolbar6.findViewById(R.id.toolbar_title);

        txtBlank = (TextView) findViewById(R.id.textView0);
        txtSend = (TextView) findViewById(R.id.textView1);

        //txtBlank.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.textView0:

                intent = new Intent(NextActivityScreen6.this, NextActivityScreen.class);
                startActivity(intent);
                break;

            case R.id.textView1:

                intent = new Intent(NextActivityScreen6.this, NextActivityScreen2.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.activity_new6menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
