package com.example.mousa.semitabs.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mousa.semitabs.About;
import com.example.mousa.semitabs.About_App;
import com.example.mousa.semitabs.Add_News;
import com.example.mousa.semitabs.Login;
import com.example.mousa.semitabs.R;

/**
 * Created by Mousa on 2/11/2018.
 */

public class fragment_menu extends Fragment {
    Button post_news;
    Button aboutt;
    Button aboutapp;


    public fragment_menu() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.menu,container,false);
        post_news=(Button)view.findViewById(R.id.post_news);
        aboutt=(Button)view.findViewById(R.id.abo);
        aboutapp=(Button)view.findViewById(R.id.abopr);
        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), About_App.class);
                startActivity(intent);

            }
        });
        post_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Login.class);
                startActivity(intent);

            }
        });
        aboutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), About.class);
                startActivity(intent);
            }
        });


    return view;
    }
}
