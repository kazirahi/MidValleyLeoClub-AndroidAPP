package com.example.differentway.midvalleyleoclub;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class About extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drawer);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        ActionBarDrawerToggle actionBarDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.Open_Drawer,R.string.Close_Drawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
//    public void onBackPressed(){
//        super.onBackPressed();
//        if(backPressedTime+20000>System.currentTimeMillis())
//        {
//            backToast.cancel();
//            super.onBackPressed();
//            return;
//        }
//        else {
//            backToast= Toast.makeText(getBaseContext(),"Press again want to exit",Toast.LENGTH_SHORT);
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
            Intent intent=new Intent(About.this,About.class);
            startActivity(intent);
            return true;
        }
        if(id==android.R.id.home)
        {
            Intent intent=new Intent(About.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        if(id==R.id.mailbar)
        {
            String[] eeMail = {"sifat9468@gmail.com", "sultanasamia24@yahoo.com", "kazirahi1234@gmail.com", "najmulhaque500@gmail.com", "shahjadabishal@gmail.com", "tusarsarker71@gmail.com", "jakia9429@gmail.com", "tasfiqul234@gmail.com", "rakibhasantex33@gmail.com", "mehjabenahmed04@gmail.com", "migrate.sizu@gmail.com", "priteemony.a@gmail.com", "mhtanvirmondol333@gmail.com", "sikderalamin2017@gmail.com", "smem3389@gmail.com", "tumpac70@gmail.com", "obaydul841@gmail.com", "nazmuldrmc95@gmail.com","mahmud89p@gmail.com","zilany1984@yahoo.com","bipulnk17@gmail.com","monsurnk90@gamil.com"};
            Intent email = new Intent(Intent.ACTION_SEND);
            email.setData(Uri.parse("mailto:"));
            email.putExtra(Intent.EXTRA_EMAIL,eeMail);
            //email.putExtra(Intent.EXTRA_SUBJECT, "");
            //email.putExtra(Intent.EXTRA_TEXT, "Hello this is for testing purposes");
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email,"Send Email"));
            return true;
        }
        if (id==R.id.Exit)
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Do you want to exit!").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                          finish();

                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
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
