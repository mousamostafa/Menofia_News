package com.example.mousa.semitabs.Search;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mousa.semitabs.Adapters.Adapter_search;
import com.example.mousa.semitabs.Fragments.fragment_Home;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Model.listitem_Detl_search;
import com.example.mousa.semitabs.R;
import com.example.mousa.semitabs.Search.Serchh;
import com.example.mousa.semitabs.UI.Start;

import java.util.ArrayList;

/**
 * Created by Mousa on 2/25/2018.
 */

public class Top_search extends Fragment {
    Adapter_search adapter_search;
    RecyclerView recyclerView;
    ArrayList<listitem_Detl_search> flitermode;

    public Top_search(){

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_search,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recy);
        recyclerView.setAdapter(adapter_search);

        Serchh.srch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {
                if(count == 0 ){
                    recyclerView.getRecycledViewPool().clear();


                }
                else {
                    filter(query.toString());
                }

            }
        });
        LinearLayoutManager linearLayout=new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayout);
        return view;

    }

    public void filter(String query) {
        if (Start.flag == 1) {
            flitermode = new ArrayList<>();
            flitermode.clear();
            for (listitem_Detl_search model : Start.listNews_search) {
                if (model.getTitle().contains(query) || model.getinfo().contains(query)) {
                    Adapter_search.x = 1;
                    Adapter_search.y = 1;
                    model.setTexsrch(query);
                    flitermode.add(model);
                } else if (model.getTitle().contains(query)) {
                    Adapter_search.x = 0;
                    Adapter_search.y = 1;
                    flitermode.add(model);
                } else if (model.getinfo().contains(query)) {
                    Adapter_search.x = 1;
                    Adapter_search.y = 0;
                    model.setTexsrch(query);
                    flitermode.add(model);
                }

            }
            adapter_search = new Adapter_search(getActivity(), flitermode);
            recyclerView.setAdapter(adapter_search);
        }
        else if(Start.flag==2){
            flitermode = new ArrayList<>();
            flitermode.clear();
            for (listitem_Detl_search model : Start.listNews_searchEn) {
                if (model.getTitle().contains(query) || model.getinfo().contains(query)) {
                    Adapter_search.x = 1;
                    Adapter_search.y = 1;
                    Adapter_search.z=1;
                    model.setTexsrch(query);
                    flitermode.add(model);
                } else if (model.getTitle().contains(query)) {
                    Adapter_search.x = 1;
                    Adapter_search.y = 1;
                    Adapter_search.z=0;
                    flitermode.add(model);
                } else if (model.getinfo().contains(query)) {
                    Adapter_search.x = 1;
                    Adapter_search.y = 0;
                    Adapter_search.z=1;
                    model.setTexsrch(query);
                    flitermode.add(model);
                }

            }
            adapter_search = new Adapter_search(getActivity(), flitermode);
            recyclerView.setAdapter(adapter_search);
        }

        }
    }


