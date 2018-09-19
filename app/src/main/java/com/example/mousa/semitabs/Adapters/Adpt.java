package com.example.mousa.semitabs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mousa.semitabs.R;
import com.example.mousa.semitabs.AboutInfo;
import com.squareup.picasso.Picasso;

import static com.example.mousa.semitabs.UI.Start.flag;

public class Adpt extends RecyclerView.Adapter<Adpt.viewholder> {
    private final String[] arr;
    Intent Openlink;
    View view;
    private final String[] arrr;
    private final int[] imgr;

    private Context context;

    public Adpt(String[] arr, String[] arrr, int[] imgr, Context context) {
        this.arr = arr;
        this.arrr = arrr;
        this.imgr = imgr;
        this.context = context;
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtitle;


        viewholder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            txtitle = (TextView) itemView.findViewById(R.id.ok);

        }
    }


    @Override
    public Adpt.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(flag==1){
             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_row, parent, false);

        }
        else if(flag==2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_rowen, parent, false);
        }

        viewholder viewHolder = new viewholder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(viewholder holder, final int position) {

        holder.txtitle.setText(arr[position]);
        holder.imageView.setImageResource(imgr[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openlink = new Intent(context, AboutInfo.class);
                Openlink.putExtra("info",arrr[position]);
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);
            }
        });
        holder.txtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openlink = new Intent(context, AboutInfo.class);
                Openlink.putExtra("info",arrr[position]);
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);
            }
        });
    }



    @Override
    public int getItemCount() {
        return arr.length;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}








