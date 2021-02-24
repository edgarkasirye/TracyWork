package com.example.NEMACOLLECT;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class NextActivityScreen extends AppCompatActivity {

    TextView itm;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    //string[] array = new string[];
    ArrayList<String> arrayList;
    private String[] array = {"doc1","doc2"};
   private boolean sortAscending = true;
   private boolean unSorted = true;



    @RequiresApi(api = Build.VERSION_CODES.P)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);


       // handleIntent(getIntent());
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_stay_current_portrait_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView mTitle = (TextView) toolbar1.findViewById(R.id.toolbar_title);


        ListView myListView = findViewById(R.id.myListView);

        initializeViews();

       // Intent intent = getIntent();
       // if(Intent.ACTION_SEARCH.equals(intent.getAction())){
       //     String query = intent.getStringExtra(SearchManager.QUERY);
      //      doMySearch(query);
      //  }
    }

   // DatabaseTable db = new DatabaseTable(this);
   // private void doMySearch(String query) {

   // }

  //   @SuppressLint("MissingSuperCall")
  //  @Override
  //  protected void onNewIntent(Intent intent) {
  //      setIntent(intent);
  //      handleIntent(intent);

  //  }
  //  private void handleIntent(Intent intent) {
  //      Intent intent = getIntent();
 //       if(Intent.ACTION_SEARCH.equals(intent.getAction())){
 //           String query = intent.getStringExtra(SearchManager.QUERY);
 //           Cursor c = db.getWordMatches(query, null);
 //           doMySearch(query);
 //       }
 //   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.activity_new1menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    private void initializeViews() {
        ListView myListView = findViewById(R.id.myListView);
        myListView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, array));

    }



       // TextView itm  =  findViewById(R.id.ascend);
      //  itm.setOnClickListener(new View.OnClickListener() {
       //     @Override
            public void onClick(View view) {
                sortData();
            }
       // });

    // }
    private void sortData() {
         List<String>arrayList=Arrays.asList(array);
         if (unSorted) Collections.sort(arrayList);
         else
             reverse(arrayList);

        sortAscending=!sortAscending;

        ListView myListView = findViewById(R.id.myListView);
        myListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,array));


    }

}

