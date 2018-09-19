package com.example.mousa.semitabs.Adapters;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mousa.semitabs.DetalNews;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Model.listitem_Detl_search;
import com.example.mousa.semitabs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_search extends RecyclerView.Adapter<Adapter_search.viewholder> {

    Intent Openlink;
  public   static int x ;
   public static int y ;
    public static int z ;


    private ArrayList<listitem_Detl_search> listite = new ArrayList<listitem_Detl_search>();
    private Context context;


    public Adapter_search(Context context, ArrayList<listitem_Detl_search> list) {
        this.listite = list;
        this.context = context;
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtitle;
        private TextView txch;
        private TextView txchde;



        viewholder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            txtitle = (TextView) itemView.findViewById(R.id.textitle);
            txch = (TextView) itemView.findViewById(R.id.texserch);
            txchde = (TextView) itemView.findViewById(R.id.tdd);
            if (x == 1) {
                txch.setVisibility(View.VISIBLE);
            }
            else {
                txch.setVisibility(View.INVISIBLE);
            }
            if(y==1){
                txtitle.setVisibility(View.VISIBLE);
            }
            else {
                txtitle.setVisibility(View.INVISIBLE);

            }
            if(z==1){
                txchde.setVisibility(View.VISIBLE);
            }
            else {
                txchde.setVisibility(View.INVISIBLE);
            }

        }
    }


    @Override
    public Adapter_search.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        viewholder viewHolder = new viewholder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(viewholder holder, final int position) {
        holder.txch.setText(listite.get(position).getTexsrch());
       holder.txtitle.setText("Tiltle : "+listite.get(position).getTitle());
        holder.txchde.setText("Details : "+listite.get(position).getDate());

        Picasso.with(context).load("http://mu.menofia.edu.eg/PrtlFiles/uni/Portal/Images/" + listite.get(position).getImg()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openlink = new Intent(context, DetalNews.class);
                Openlink.putExtra("img", listite.get(position).getImg());
                Openlink.putExtra("tit",listite.get(position).getTitle());
                Openlink.putExtra("dat",listite.get(position).getDate());
                Openlink.putExtra("inf",listite.get(position).getinfo());
                Openlink.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Openlink);
            }
        });
        holder.txtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openlink = new Intent(context, DetalNews.class);
                Openlink.putExtra("img", listite.get(position).getImg());
                Openlink.putExtra("tit",listite.get(position).getTitle());
                Openlink.putExtra("dat",listite.get(position).getDate());
                Openlink.putExtra("inf",listite.get(position).getinfo());
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








