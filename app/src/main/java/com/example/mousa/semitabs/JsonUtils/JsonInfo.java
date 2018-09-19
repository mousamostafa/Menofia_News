package com.example.mousa.semitabs.JsonUtils;

import retrofit2.Retrofit;

public class JsonInfo {

    public final String baseurl="http://mosamostafa-001-site1.itempurl.com/";
    public Retrofit retrofit=null;


    public Retrofit getjson(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(baseurl).build();
        }
        return retrofit;
    }


}
