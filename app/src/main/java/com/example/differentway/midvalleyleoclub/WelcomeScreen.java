package com.example.differentway.midvalleyleoclub;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WelcomeScreen extends AppCompatActivity {
    private static int Splash_time_out=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeIntent=new Intent(WelcomeScreen.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },Splash_time_out);
    }
    public boolean onCreateOptionMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

}
