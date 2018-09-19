package com.example.mousa.semitabs.JsonUtils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface News_Interface {


@GET("aa.php")
    Call<ResponseBody> getnews();

    @POST("insert.php")
    @FormUrlEncoded
    Call<ResponseBody> setnews(@Field("News_Head") String title,@Field("News_Abbr")String infor,
                               @Field("News_Body")String body, @Field("News_Source")String source,
                               @Field("Lang_Id")int lid,
                               @Field("News_Id")int news_id,
                               @Field("Img_alt")String imgalt,
                               @Field("device_id")String id);

    @GET("insert.php") Call<ResponseBody> getlastrecord();
}


