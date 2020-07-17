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

public class ClubMember extends BaseAdapter {
    Intent chooser ;

    private Context context;
    String[] mmTitle = { "Leo Kazi Samsul Alam Rahi", "Leo Md Najmul Haque", "Leo Mehjaben Ahmed", "Leo Mohammad Rakib Gazi",  "Leo Tasfiqul Hasan", "Leo Tumpa Chakrabortty","Leo Faria Ferdowsy",  "Leo Md. Delwar Hossin Sizer",
             "Leo Mehedi Hasan Tanvir",  "Leo Shamim Hasan Mim",
    };
    String[] ssTitle = {"President",  "Vice President - 1","Vice President - 2", "Secretary", "Treasurer", "Joint Secretary", "Joint Treasurer", "Senior Member", "Senior Member", "Senior Member"};
    int[] iimgID = { R.drawable.rahi, R.drawable.najmul, R.drawable.mehjabin,R.drawable.rakibg, R.drawable.tasfiq, R.drawable.tumpa, R.drawable.priteemony,   R.drawable.sizar,  R.drawable.tanvir,  R.drawable.mim };
    String[] bbloodGrp = { "Blood Group: B+", "Blood Group: AB+",  "Blood Group: B+",  "Blood Group: O+","Blood Group: B+","Blood Group: A+", "Blood Group: AB+", "Blood Group: B+",  "Blood Group: O+",
            "Blood Group: "
    };
    String[] mmblNmbr = { "tel:+8801521209010", "tel:+8801742449582", "tel:+8801749149073","tel:+8801735238409", "tel:+8801782253086","tel:+8801770110954",  "tel:+8801521429836", "tel:+8801717515340",  "tel:+8801787425829",  "tel:+8801727155272" };

    String[] eeMail = { "kazirahi1234@gmail.com", "najmulhaque500@gmail.com", "mehjabenahmed04@gmail.com","bd.gazi67@gmail.com", "tasfiqul234@gmail.com","tumpac70@gmail.com", "priteemony.a@gmail.com",  "migrate.sizu@gmail.com",  "mhtanvirmondol333@gmail.com",  "smem3389@gmail.com" };

    public ClubMember(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mmTitle.length;
    }

    @Override
    public Object getItem(int position) {
        return mmTitle[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.club_member_res, null);
        }
        ImageView jcall, jsms, jemail, jimage;
        TextView jmtitle, jstitle, jbloodgrp;
        jcall = convertView.findViewById(R.id.jcall);
        jsms = convertView.findViewById(R.id.jsms);
        jemail = convertView.findViewById(R.id.jemail);
        jimage = convertView.findViewById(R.id.jimage);
        jmtitle = convertView.findViewById(R.id.jMtitle);
        jstitle = convertView.findViewById(R.id.jStitle);
        jbloodgrp = convertView.findViewById(R.id.jbldgrp);


        //setview
        jmtitle.setText(mmTitle[position]);
        jstitle.setText(ssTitle[position]);
        jbloodgrp.setText(bbloodGrp[position]);
        jimage.setImageResource(iimgID[position]);

        jcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(mmblNmbr[position]));
                context.startActivity(intent);
            }
        });
        jemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{eeMail[position]});
                //email.putExtra(Intent.EXTRA_SUBJECT, "Testing");
                //email.putExtra(Intent.EXTRA_TEXT, "Hello this is for testing purposes");
                email.setType("message/rfc822");
                context.startActivity(Intent.createChooser(email,""));
            }
        });
        jsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", mmblNmbr[position], null));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
