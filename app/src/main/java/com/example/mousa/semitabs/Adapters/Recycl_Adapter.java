package com.example.mousa.semitabs.Adapters;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mousa.semitabs.DetalNews;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycl_Adapter extends RecyclerView.Adapter<Recycl_Adapter.viewholder> {

    Intent Openlink;

    private ArrayList<listitem> listite = new ArrayList<listitem>();
    private Context context;

    public Recycl_Adapter(Context context, ArrayList<listitem> list) {
        this.listite = list;
        this.context = context;
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView texx;
        viewholder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.home_img);
            texx=(TextView)itemView.findViewById(R.id.titlenews);

        }
    }


    @Override
    public Recycl_Adapter.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        viewholder viewHolder = new viewholder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(viewholder holder, final int position) {
         holder.texx.setText(listite.get(position).title);
        Picasso.with(context).load("http://mu.menofia.edu.eg/PrtlFiles/uni/Portal/Images/" + listite.get(position).getImg()).into(holder.poster);
        holder.texx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openlink = new Intent(context, DetalNews.class);
                Openlink.putExtra("img", listite.get(position).getImg());
                Openlink.putExtra("tit",listite.get(position).getTitle());
                Openlink.putExtra("dat",listite.get(position).getDate());
                Openlink.putExtra("inf",listite.get(position).getinfo());
                Openlink.putExtra("src",listite.get(position).getSource());
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);

            }
        });
        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openlink = new Intent(context, DetalNews.class);
                Openlink.putExtra("img", listite.get(position).getImg());
                Openlink.putExtra("tit",listite.get(position).getTitle());
                Openlink.putExtra("dat",listite.get(position).getDate());
                Openlink.putExtra("inf",listite.get(position).getinfo());
                Openlink.putExtra("src",listite.get(position).getSource());
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);
            }
        });
          }


    @Override
    public int getItemCount() {
        return listite.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
        /*


*/







