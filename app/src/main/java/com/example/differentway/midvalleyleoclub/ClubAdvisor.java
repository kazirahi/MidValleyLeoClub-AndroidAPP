package com.example.differentway.midvalleyleoclub;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.support.v7.widget.Toolbar;

public class ClubAdvisor extends AppCompatActivity {
    ImageView acall,asms,aemail;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_advisor);
        acall=findViewById(R.id.adcall);
        asms=findViewById(R.id.adsms);
        aemail=findViewById(R.id.ademail);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        acall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+8801833335555"));
                startActivity(intent);
            }
        });
        aemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"kazi_aminul@hotmail.com"});
                //email.putExtra(Intent.EXTRA_SUBJECT, "Testing");
                //email.putExtra(Intent.EXTRA_TEXT, "Hello this is for testing purposes");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,""));
            }
        });
        asms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "tel:+8801833335555", null));
                startActivity(intent);
            }
        });

    }
}
