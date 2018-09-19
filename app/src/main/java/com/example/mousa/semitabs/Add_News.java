package com.example.mousa.semitabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mousa.semitabs.Adapters.Notification_Adapter;
import com.example.mousa.semitabs.Fragments.fragment_Notification;
import com.example.mousa.semitabs.JsonUtils.JsonInfo;
import com.example.mousa.semitabs.JsonUtils.News_Interface;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Notification.fireNotification;
import com.example.mousa.semitabs.UI.InstanceIDService;

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

import static com.example.mousa.semitabs.UI.Start.flag;

public class Add_News extends AppCompatActivity {
    Intent Openlink;
    ImageView imageView;
    Button button;
    ImageButton takeImg;
    EditText edtitle;
    EditText eddetail;
    EditText edsource;
    EditText edlang;
    Button addnewss;
    Intent intentt;
  public static int flagnot=0;
    SharedPreferences sharedPreferences;
   public static String resp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_layout);
        takeImg=(ImageButton)findViewById(R.id.Img_Btn);
        edtitle=(EditText)findViewById(R.id.Header_Txt);
        eddetail=(EditText)findViewById(R.id.Details_Txt);
        edsource=(EditText)findViewById(R.id.Src_Txt);
        edlang=(EditText)findViewById(R.id.lang);
        addnewss=(Button)findViewById(R.id.Post_Btn);
        intentt=new Intent(getApplicationContext(),MainActivity.class);
        sharedPreferences=getSharedPreferences("myfile",MODE_PRIVATE);







takeImg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 100);
        intent.putExtra("outputY", 100);
        intent.putExtra("return-data", "true");
        startActivityForResult(intent, 100);
    }
});




                addnewss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                if(!fireNotification.serviceIsrun) {
                    fireNotification.serviceIsrun = true;
                    Intent intent = new Intent(getApplicationContext(), fireNotification.class);
                    startService(intent);
                    startActivity(intentt);
                    flagnot=1;




                }
            }
        });

    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 & resultCode == RESULT_OK) {
            takeImg.setImageBitmap((Bitmap) data.getExtras().get("data"));

        }
    }

    public void insert() {
        String baseurll = "http://mosamostafa-001-site1.itempurl.com/";
        Retrofit re;
        re = new Retrofit.Builder().baseUrl(baseurll).build();
        News_Interface news_interface = re.create(News_Interface.class);
        news_interface.setnews(edtitle.getText().toString(), eddetail.getText().toString(), "meeeeeeeee", edsource.getText().toString(), Integer.parseInt(edlang.getText().toString()), 1, "moooooosa",
                InstanceIDService.refreshedToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                SharedPreferences.Editor myedit=sharedPreferences.edit();
                String word= null;
                try {
                    word = response.body().string();
                    myedit.putString("data",word);
                    myedit.commit();
                    resp=sharedPreferences.getString("data","Empty");
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
