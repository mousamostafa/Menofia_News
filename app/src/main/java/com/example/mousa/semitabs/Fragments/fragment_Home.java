package com.example.mousa.semitabs.Fragments;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mousa.semitabs.Adapters.Adapter_search;
import com.example.mousa.semitabs.JsonUtils.JsonInfo;
import com.example.mousa.semitabs.JsonUtils.News_Interface;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Model.listitem_Detl_search;
import com.example.mousa.semitabs.Adapters.Recycl_Adapter;
import com.example.mousa.semitabs.R;
import com.example.mousa.semitabs.UI.Start;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class fragment_Home extends Fragment {
    RecyclerView.LayoutManager layoutManager;
   public static RecyclerView recyclerView;
    public fragment_Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyle);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(Start.recycl_adapter);
        return view;
    }

}
