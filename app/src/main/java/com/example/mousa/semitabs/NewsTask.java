package com.example.mousa.semitabs;
/*
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mousa.semitabs.Adapters.Adapter_search;
import com.example.mousa.semitabs.Adapters.Recycl_Adapter;
import com.example.mousa.semitabs.JsonUtils.JsonInfo;
import com.example.mousa.semitabs.JsonUtils.News_Interface;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Model.listitem_Detl_search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsTask extends AsyncTask<Void, Void, Void> {
    Adapter_search adapter_search;
    Recycl_Adapter recycl_adapter;
    public static ArrayList<listitem> listNews = new ArrayList<listitem>();
    public static ArrayList<listitem_Detl_search> listNews_search = new ArrayList<listitem_Detl_search>();
    public static ArrayList<listitem> listNewsEn = new ArrayList<listitem>();
    public static ArrayList<listitem_Detl_search> listNews_searchEn = new ArrayList<listitem_Detl_search>();
    JsonInfo jsonInfo = new JsonInfo();
    int news_id;
    String img;
    String date;
    int lang_id;
    String news_head;
    String news_details;
    String src;
    public static int flag = 0;
    Context context;
    RecyclerView re;

    public NewsTask(Context context, RecyclerView re) {
        this.context = context;
        this.re = re;
    }

    @Override
    protected Void doInBackground(Void... voids) {


                    //-------------------------------------------------------------------------------
                    //For Search  in all news---------------------------------------------

                    for (int x = 226; x < jsonArray.length(); x++) {
                        JSONObject nnews = jsonArray.getJSONObject(x);
                        news_id = nnews.getInt("News_Id");
                        img = nnews.getString("News_img");
                        String objectnnull = nnews.getString("News_date");
                        news_head = nnews.getString("News_Head");
                        news_details = nnews.getString("News_Abbr");
                        src = nnews.getString("News_Source");
                        lang_id = nnews.getInt("Lang_Id");

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
                            listNews_search.add(new listitem_Detl_search(news_head, news_details, date, img, src));
                        } else if (lang_id == 2) {
                            listNews_searchEn.add(new listitem_Detl_search(news_head, news_details, date, img, src));
                        }


                    }




//-----------------------------------------------------------------------------------------------------------------------------


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();

            }
        });


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}




*/