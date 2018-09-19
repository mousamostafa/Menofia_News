package com.example.mousa.semitabs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mousa.semitabs.DetalNews;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.mousa.semitabs.UI.Start.flag;

public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.viewholder> {
          Intent Openlink;
         private ArrayList<listitem> listitenot = new ArrayList<listitem>();
    public static Context context;
   public static ArrayAdapter<String> arrayAdapter;

    public Notification_Adapter(ArrayList<listitem> listitenot, Context context) {
        this.listitenot = listitenot;
        this.context = context;
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        Spinner spinner;
    ImageView imggnot;
    TextView texxnot;
    viewholder(View itemView) {
        super(itemView);
        imggnot = (ImageView) itemView.findViewById(R.id.imageViewnotifi);
        texxnot=(TextView)itemView.findViewById(R.id.ok);
        spinner=(Spinner) itemView.findViewById(R.id.hide);
        String [] s={"Hide this notification"};
        String [] ss={"إاخفاء هذا الخبر "};
       if(flag==1){
            arrayAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item,ss);

       }
       else if(flag==2){
           arrayAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item,s);

       }

    }
}


    @Override
    public Notification_Adapter.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

    if(flag==1) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_row, parent, false);
        Notification_Adapter.viewholder viewHolder = new Notification_Adapter.viewholder(view);
        return viewHolder;
    }
    else {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noification_rowen, parent, false);

        Notification_Adapter.viewholder viewHolder = new Notification_Adapter.viewholder(view);
        return viewHolder;
    }

    }


    @Override
    public void onBindViewHolder(Notification_Adapter.viewholder holder, final int position) {
        holder.spinner.setAdapter(arrayAdapter);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listitenot.remove(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    if(flag==1) {
        holder.texxnot.setText("قام " + listitenot.get(position).source+ "" +" باضافة خبر جديد ");
    }
    else if (flag==2) {
        holder.texxnot.setText(listitenot.get(position).source+ " Add New News" );
         Log.d("imggggggg",listitenot.get(position).getImg());

    }
        Picasso.with(context).load("http://mu.menofia.edu.eg/PrtlFiles/uni/Portal/Images/" + listitenot.get(position).getImg()).into(holder.imggnot);
        holder.texxnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openlink = new Intent(context, DetalNews.class);
                Openlink.putExtra("img", listitenot.get(position).getImg());
                Openlink.putExtra("tit",listitenot.get(position).getTitle());
                Openlink.putExtra("dat",listitenot.get(position).getDate());
                Openlink.putExtra("inf",listitenot.get(position).getinfo());
                Openlink.putExtra("src",listitenot.get(position).getSource());
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);

            }
        });
        holder.imggnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openlink = new Intent(context, DetalNews.class);
                Openlink.putExtra("img", listitenot.get(position).getImg());
                Openlink.putExtra("tit",listitenot.get(position).getTitle());
                Openlink.putExtra("dat",listitenot.get(position).getDate());
                Openlink.putExtra("inf",listitenot.get(position).getinfo());
                Openlink.putExtra("src",listitenot.get(position).getSource());
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listitenot.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}

