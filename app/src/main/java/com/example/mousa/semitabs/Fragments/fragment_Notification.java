package com.example.mousa.semitabs.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mousa.semitabs.Adapters.Notification_Adapter;
import com.example.mousa.semitabs.Add_News;
import com.example.mousa.semitabs.DetalNews;
import com.example.mousa.semitabs.JsonUtils.JsonInfo;
import com.example.mousa.semitabs.JsonUtils.News_Interface;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.R;
import com.example.mousa.semitabs.UI.Start;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;
import static com.example.mousa.semitabs.UI.Start.flag;


/**
 * Created by Mousa on 2/11/2018.
 */

public class fragment_Notification extends Fragment {
    TextView txtilte;
    JsonInfo jsonInfo;
    int news_idnot;
    String imgnot;
    String datenot;
    int lang_idnot;
    String news_headnot;
    String news_detailsnot;
    String srcnot;
    public static ArrayList<listitem> listNewsnot = new ArrayList<listitem>();
    public static ArrayList<listitem> listNewsEnnot = new ArrayList<listitem>();
    public static Notification_Adapter notification_adapter;
   public static RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManagerw;

    public fragment_Notification() {
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recylenotif);

        layoutManagerw = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManagerw);
        recyclerView.setHasFixedSize(true);
            getnoot();
        return view;

    }

void getnoot(){
    String baseurlll = "http://mosamostafa-001-site1.itempurl.com/";
    Retrofit reee;
    reee = new Retrofit.Builder().baseUrl(baseurlll).build();
    News_Interface news_interfaceee = reee.create(News_Interface.class);
    news_interfaceee.getlastrecord().enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            try {

                Log.d("inserrrrrrrrrt","inserrrrrrrrrrrt");
                Log.d("nottttttttttt",response.body().string());
                JSONObject jsonObject = null;
                jsonObject = new JSONObject(response.body().string());
                JSONArray jsonArray = jsonObject.getJSONArray("allnews");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject nnews = jsonArray.getJSONObject(i);
                    Log.d("jsoooooon",response.body().string());
                    //news_idnot = nnews.getInt("News_Id");
                    //imgnot = nnews.getString("News_img");
                    news_headnot = nnews.getString("News_Head");
                    news_detailsnot = nnews.getString("News_Abbr");
                    srcnot = nnews.getString("News_Source");
                    lang_idnot = nnews.getInt("Lang_Id");
                    imgnot="3fdf6cf3-cc17-4abd-b6e0-a3c6e709fd44.png";
                    //  datenot = nnews.getString("date");

                    //Log.d("object", objectnnull);
/*
                        if (img.equals("null")) {
                            img = "3fdf6cf3-cc17-4abd-b6e0-a3c6e709fd44.png";
                        }

                        if (objectnnull.equals("null")) {
                            date = "";
                            Log.d("fffffff", "null" + String.valueOf(news_id));
                        } else {
                            JSONObject object = nnews.getJSONObject("News_date");
                            date = object.getString("date").substring(0, 10);
                            Log.d("date", date + " " + String.valueOf(news_id));
                        }
*/
                    if (lang_idnot == 1) {
                        Log.d("listnoooooot","adddok");
                        listNewsnot.add(new listitem(news_headnot, news_detailsnot, "3/7/2018", imgnot, srcnot));
                    } else if (lang_idnot == 2) {
                        Log.d("listennnn","okkkkkkken");
                        listNewsEnnot.add(new listitem(news_headnot, news_detailsnot, "3/7/2018", imgnot, srcnot));
                    }
                }
                if(flag==1){
                    notification_adapter=new Notification_Adapter(listNewsnot,getActivity());
                    Log.d("aadaaaaaa","flaaaaag");
                    recyclerView.setAdapter(notification_adapter);

                }
                else if(flag==2){
                    notification_adapter=new Notification_Adapter(listNewsEnnot,getActivity());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

        }
    });

    }




}




