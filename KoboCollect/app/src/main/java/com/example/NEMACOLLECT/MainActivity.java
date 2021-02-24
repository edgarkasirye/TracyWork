package com.example.NEMACOLLECT;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6;
    //TextView txtBlank;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_baseline_stay_current_portrait_24);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);


        button1 = (Button) findViewById(R.id.buttonOne);
        button2 = (Button) findViewById(R.id.buttonTwo);
        button3 = (Button) findViewById(R.id.buttonThree);
        button4 = (Button) findViewById(R.id.buttonFour);
        button5 = (Button) findViewById(R.id.buttonFive);
        button6 = (Button) findViewById(R.id.buttonSix);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);



    }


    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {

            case R.id.buttonOne:

                intent = new Intent(MainActivity.this, NextActivityScreen.class);
                startActivity(intent);
                break;

            case R.id.buttonTwo:

                intent = new Intent(MainActivity.this, NextActivityScreen2.class);
                startActivity(intent);
                break;
            case R.id.buttonThree:
                intent = new Intent(MainActivity.this, NextActivityScreen3.class);
                startActivity(intent);
                break;
            case R.id.buttonFour:
                intent = new Intent(MainActivity.this, NextActivityScreen4.class);
                startActivity(intent);
                break;
            case R.id.buttonFive:
                intent = new Intent(MainActivity.this, NextActivityScreen5.class);
                startActivity(intent);
                break;
            case R.id.buttonSix:
                intent = new Intent(MainActivity.this, NextActivityScreen6.class);
                startActivity(intent);
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }

    public boolean onOptionsItemsSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, NextActivityScreen7.class);
                startActivity(intent);
                break;
            case R.id.item2:
                 intent = new Intent(MainActivity.this, NextActivityScreen8.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}





