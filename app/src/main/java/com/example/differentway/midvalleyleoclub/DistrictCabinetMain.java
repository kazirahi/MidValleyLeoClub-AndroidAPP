package com.example.differentway.midvalleyleoclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class DistrictCabinetMain extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_cabinet_main);
        listView=findViewById(R.id.lvDis);
        DistrictCabinet districtCabinet=new DistrictCabinet(this);
        listView.setAdapter(districtCabinet);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
