package com.example.differentway.midvalleyleoclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class ClubMemberMain extends AppCompatActivity {
    ListView  listView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_member);
        listView=findViewById(R.id.lvclubmember);
        ClubMember clubMember=new ClubMember(this);
        listView.setAdapter(clubMember);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
