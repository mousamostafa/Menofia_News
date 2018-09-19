package com.example.mousa.semitabs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mousa.semitabs.R;

public class Adapter_Leader extends RecyclerView.Adapter<Adapter_Leader.viewholder> {

private final String[] name;
View view;
private final int[] imgr;
private Context context;

    public Adapter_Leader(String[] name, int[] imgr, Context context) {
        this.name = name;
        this.imgr = imgr;
        this.context = context;
    }

    public static class viewholder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView txtitle;


    viewholder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imgleader);
        txtitle = (TextView) itemView.findViewById(R.id.nameleader);

    }
}


    @Override
    public Adapter_Leader.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaders, parent, false);


        Adapter_Leader.viewholder viewHolder = new Adapter_Leader.viewholder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(Adapter_Leader.viewholder holder, final int position) {
        holder.txtitle.setText(name[position]);
        holder.imageView.setImageResource(imgr[position]);
          }



    @Override
    public int getItemCount() {
        return name.length;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
