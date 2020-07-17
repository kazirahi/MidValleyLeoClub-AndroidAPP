package com.example.differentway.midvalleyleoclub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClubDirector extends BaseAdapter {

    private Context context;
    String[] mTitle = {"Leo Kazi Mahmud", "Leo Sultana Samia" };
    String[] sTitle = {"Club Director",  "Club Director"};
    int[] imgID = {R.drawable.mahmud,R.drawable.alice };
    String[] bloodGrp = {"Blood Group: B+","Blood Group: A+"  };
    String [] mblNmbr = {"tel:+8801676139603","tel:+8801622430044"};
    String [] eMail = {"mahmud89p@gmail.com","sultanasamia24@yahoo.com"};

    public ClubDirector(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public Object getItem(int position) {
        return mTitle[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.club_director, null);
        }
        ImageView call, sms, email, image;
        TextView mtitle, stitle, bloodgrp;
        call = convertView.findViewById(R.id.icall);
        sms = convertView.findViewById(R.id.isms);
        email = convertView.findViewById(R.id.iemail);
        image = convertView.findViewById(R.id.image);
        mtitle = convertView.findViewById(R.id.Mtitle);
        stitle = convertView.findViewById(R.id.Stitle);
        bloodgrp = convertView.findViewById(R.id.bldgrp);


        //setview
        mtitle.setText(mTitle[position]);
        stitle.setText(sTitle[position]);
        bloodgrp.setText(bloodGrp[position]);
        image.setImageResource(imgID[position]);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(mblNmbr[position]));
                context.startActivity(intent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{eMail[position]});
                //email.putExtra(Intent.EXTRA_SUBJECT, "Testing");
                //email.putExtra(Intent.EXTRA_TEXT, "Hello this is for testing purposes");
                email.setType("message/rfc822");
                context.startActivity(Intent.createChooser(email,""));
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", mblNmbr[position], null));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
