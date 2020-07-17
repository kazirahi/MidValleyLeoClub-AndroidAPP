package com.example.differentway.midvalleyleoclub;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class Leoism extends AppCompatActivity {
    Button lion, leo, wiki, facebook, midv;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leoism);
        lion = findViewById(R.id.lion);
        leo = findViewById(R.id.leo);
        wiki = findViewById(R.id.wiki);
        facebook = findViewById(R.id.facebook);
        midv = findViewById(R.id.midvalley);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lionsclubs.org"));
                startActivity(intent);
            }
        });
        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lionsclubs.org/EN/who-we-are/mission-and-history/index.php"));
                startActivity(intent);
            }
        });
        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Leo_clubs"));
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/lionsclubs/"));
                startActivity(intent);
            }
        });
        midv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mid-valley.weebly.com/"));
                startActivity(intent);
            }
        });


    }
}
