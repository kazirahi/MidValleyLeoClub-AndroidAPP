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

public class DistrictCabinet extends BaseAdapter {

    private Context context;
    String[] Title = {"Leo Muhammad Emran Hossain","Leo Ashikul Islam Rajib","Leo Samiul Ahasan Anik","Leo MD Rifat Rahman","Leo MD Towkeer Rahim Risat","Leo MD Mir Hossain Masud"};
    String[] STitle = {"District President","Imm. District President","Vice President","District Co-Ordinator ","District Secretary","District Treasurer"};
    int[] imgI = {R.drawable.emran,R.drawable.razib, R.drawable.anik,R.drawable.rifat,R.drawable.risat,R.drawable.masud  };

    String [] MblNmbr = {"tel:+8801619192323","tel:+8801678777400","tel:+8801515652547","tel:+8801515297424","tel:+8801670441775","tel:+8801682145530"};
    String [] EMail = {"emranhss@gmail.com","ashiqrazib28@gmail.com","null@gmail.com","rifat606@gmail.com","risat420@gmail.com","leomasud530@gmail.com"};

    public DistrictCabinet(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Title.length;
    }

    @Override
    public Object getItem(int position) {
        return Title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.district_cabinet, null);
        }
        ImageView call, sms, email, image;
        TextView mtitle, stitle;
        call = convertView.findViewById(R.id.discall);
        sms = convertView.findViewById(R.id.dissms);
        email = convertView.findViewById(R.id.disemail);
        image = convertView.findViewById(R.id.disimage);
        mtitle = convertView.findViewById(R.id.disMtitle);
        stitle = convertView.findViewById(R.id.disstitle);



        //setview
        mtitle.setText(Title[position]);
        stitle.setText(STitle[position]);
        image.setImageResource(imgI[position]);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(MblNmbr[position]));
                context.startActivity(intent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{EMail[position]});
                //email.putExtra(Intent.EXTRA_SUBJECT, "Testing");
                //email.putExtra(Intent.EXTRA_TEXT, "Hello this is for testing purposes");
                email.setType("message/rfc822");
                context.startActivity(Intent.createChooser(email,""));
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", MblNmbr[position], null));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
