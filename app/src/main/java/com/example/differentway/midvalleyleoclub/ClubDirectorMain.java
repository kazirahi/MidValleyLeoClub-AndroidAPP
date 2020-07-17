package com.example.differentway.midvalleyleoclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class ClubDirectorMain extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_director_main);

        listView=findViewById(R.id.listview);
        ClubDirector  clubDirector=new ClubDirector(this);
        listView.setAdapter(clubDirector);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
