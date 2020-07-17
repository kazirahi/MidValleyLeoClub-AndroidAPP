package com.example.differentway.midvalleyleoclub;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    Button clubcab,clubdir,clubad,leo,abt,ip;
    Button clubpre,clubdis,activity;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clubpre=findViewById(R.id.clubpresident);
        clubcab=findViewById(R.id.clubcabinet);
        clubdir=findViewById(R.id.clubdirector);
        clubad=findViewById(R.id.clubadvisor);
        leo=findViewById(R.id.Leoism);
        ip=findViewById(R.id.ipp);
        clubdis=findViewById(R.id.districtcabinet);
        fb=findViewById(R.id.fbid);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] eeMail = { "sultanasamia24@yahoo.com", "kazirahi1234@gmail.com", "najmulhaque500@gmail.com",  "tasfiqul234@gmail.com",  "mehjabenahmed04@gmail.com", "migrate.sizu@gmail.com", "priteemony.a@gmail.com", "mhtanvirmondol333@gmail.com",  "smem3389@gmail.com", "tumpac70@gmail.com","tumpac70@gmail.com", "mahmud89p@gmail.com"};
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL,eeMail);
                //email.putExtra(Intent.EXTRA_SUBJECT, "");
                //email.putExtra(Intent.EXTRA_TEXT, "Hello this is for testing purposes");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Send Email"));
            }
        });
        clubdis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DistrictCabinetMain.class);
                startActivity(intent);
            }
        });
        ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Ipp.class);
                startActivity(intent);
            }
        });
        clubad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ClubAdvisor.class);
                startActivity(intent);
            }
        });
        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Leoism.class);
                startActivity(intent);
            }
        });
        abt=findViewById(R.id.Aboutdep);
        clubcab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ClubMemberMain.class);
                startActivity(intent);

            }
        });
        clubpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PresidentSpeech.class);
                startActivity(intent);
            }
        });
        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,About.class);
                startActivity(intent);
            }
        });
        clubdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ClubDirectorMain.class);
                startActivity(intent);
            }
        });

    }
//    public void onBackPressed(){
//        super.onBackPressed();
//
//        if(backPressedTime+2000>System.currentTimeMillis())
//        {
//            backToast.cancel();
//            super.onBackPressed();
//            return;
//        }
//        else {
//            backToast=Toast.makeText(getBaseContext(),"Press again want to exit",Toast.LENGTH_LONG);
//            backToast.show();
//        }
//        backPressedTime=System.currentTimeMillis();
//    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id= menuItem.getItemId();
        if(id==R.id.about)
        {
            Intent intent=new Intent(MainActivity.this,About.class);
            startActivity(intent);

            return true;
        }
        if (id==R.id.Exit)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit!").setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog= builder.create();
            alertDialog.setTitle("Alert!");
            alertDialog.show();
            return true;
        }
        return true;
    }
}
