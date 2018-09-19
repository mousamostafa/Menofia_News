package com.example.mousa.semitabs.UI;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mousa.semitabs.Adapters.Adapter_search;
import com.example.mousa.semitabs.Adapters.Recycl_Adapter;
import com.example.mousa.semitabs.JsonUtils.JsonInfo;
import com.example.mousa.semitabs.JsonUtils.News_Interface;
import com.example.mousa.semitabs.MainActivity;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Model.listitem_Detl_search;
import com.example.mousa.semitabs.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mousa on 3/4/2018.
 */

public class Start extends AppCompatActivity {
    Adapter_search adapter_search;
   public static Recycl_Adapter recycl_adapter;
    public static ArrayList<listitem> listNews = new ArrayList<listitem>();
    public static ArrayList<listitem_Detl_search> listNews_search = new ArrayList<listitem_Detl_search>();
    public static ArrayList<listitem> listNewsEn = new ArrayList<listitem>();
    public static ArrayList<listitem_Detl_search> listNews_searchEn = new ArrayList<listitem_Detl_search>();
    JsonInfo jsonInfo=new JsonInfo();
    int news_id;
    String img;
    String date;
    int lang_id;
    String news_head;
    String news_details;
    String src;
    public static int flag=0;
    public static ArrayList<listitem> re;
    ImageView imgg;
    Button textView;
    Button eng;
    ImageView log;
    String android_id;
    InstanceIDService idService = new InstanceIDService();
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        idService.onTokenRefresh();
        relativeLayout=(RelativeLayout)findViewById(R.id.relat);


        News_Interface news_interface= jsonInfo.getjson().create(News_Interface.class);
        Call<ResponseBody> call=news_interface.getnews();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject jsonObject = null;
                    jsonObject = new JSONObject(response.body().string());
                    JSONArray jsonArray = jsonObject.getJSONArray("allnews");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject nnews = jsonArray.getJSONObject(i);
                        news_id = nnews.getInt("News_Id");
                        img = nnews.getString("News_img");
                        String objectnnull = nnews.getString("News_date");
                        news_head = nnews.getString("News_Head");
                        news_details = nnews.getString("News_Abbr");
                        src = nnews.getString("News_Source");
                        lang_id = nnews.getInt("Lang_Id");
                        Log.d("object", objectnnull);

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
                        if (lang_id == 1) {
                            listNews.add(new listitem(news_head, news_details, date, img, src));
                            listNews_search.add(new listitem_Detl_search(news_head, news_details, date, img, src));

                            Log.d("newssssssssssssss", "Ok1" + date);
                        } else if (lang_id == 2) {
                            listNewsEn.add(new listitem(news_head, news_details, date, img, src));

                            listNews_searchEn.add(new listitem_Detl_search(news_head, news_details, date, img, src));
                            Log.d("newsEnonlyyyyyyyyyEn", "Ok2");
                        }
                    }
                    Log.d("finishhhhhhh", "finnnn");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        imgg = (ImageView) findViewById(R.id.imageView);
        textView = (Button) findViewById(R.id.arab);
        eng = (Button) findViewById(R.id.engl);
        log = (ImageView) findViewById(R.id.logo);
        Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        imgg.setAnimation(zoomin);
        imgg.setAnimation(zoomout);
        imgg.startAnimation(zoomin);
        imgg.startAnimation(zoomout);
        log.setAnimation(zoomin);
        log.setAnimation(zoomout);
        log.startAnimation(zoomin);
        log.startAnimation(zoomout);
        textView.setAnimation(zoomin);
        textView.setAnimation(zoomout);
        textView.startAnimation(zoomin);
        textView.startAnimation(zoomout);
        eng.setAnimation(zoomin);
        eng.setAnimation(zoomout);
        eng.startAnimation(zoomin);
        eng.startAnimation(zoomout);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                recycl_adapter = new Recycl_Adapter(getApplicationContext(), listNews);
                adapter_search = new Adapter_search(getApplicationContext(), listNews_search);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Start.this, MainActivity.class);
                startActivity(intent);
            }
        });
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=2;
                recycl_adapter = new Recycl_Adapter(getApplicationContext(), listNewsEn);
                adapter_search = new Adapter_search(getApplicationContext(), listNews_searchEn);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Start.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}


