package com.example.mousa.semitabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mousa.semitabs.Adapters.Notification_Adapter;
import com.example.mousa.semitabs.JsonUtils.JsonInfo;
import com.example.mousa.semitabs.JsonUtils.News_Interface;
import com.example.mousa.semitabs.Model.listitem;
import com.example.mousa.semitabs.Model.listitem_Detl_search;
import com.example.mousa.semitabs.Notification.fireNotification;
import com.example.mousa.semitabs.UI.InstanceIDService;
import com.example.mousa.semitabs.UI.open_image;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.mousa.semitabs.UI.Start.flag;

public class DetalNews extends AppCompatActivity {
    Intent Openlink;
    ImageView imageView;
    TextView txtilte;
    Button button;
    public static TextView txinfo;
    TextView datt;
    String img;
    String tiltle;
    String info;
    String date;
    ScrollView scrollView;
    ImageButton shar;
    ImageButton sht;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (flag == 1) {
            setContentView(R.layout.detail);
        } else if (flag == 2) {
            setContentView(R.layout.detailen);
        }
        scrollView=(ScrollView)findViewById(R.id.sc);
        imageView = (ImageView) findViewById(R.id.imag);
        txtilte = (TextView) findViewById(R.id.titl);
        txinfo = (TextView) findViewById(R.id.detail);
        datt = (TextView) findViewById(R.id.date);
        shar=(ImageButton)findViewById(R.id.shar);
        sht=(ImageButton)findViewById(R.id.shot);
        Bundle extras = getIntent().getExtras();

        final open_image fragment = new open_image();

        if (extras != null) {
            img = extras.getString("img");

            tiltle = extras.getString("tit");
            Picasso.with(DetalNews.this).load("http://mu.menofia.edu.eg/PrtlFiles/uni/Portal/Images/" + img).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Openlink = new Intent(DetalNews.this, open_image.class);
                    Openlink.putExtra("img", img);
                    startActivity(Openlink);
                }
            });


            txtilte.setText(tiltle);
            date = extras.getString("dat");
            datt.setText(date);
            info = extras.getString("inf");
            if (flag == 1) {
                txinfo.setText("تفاصيل الخبر : " + "\n" + info);
            } else if (flag == 2) {
                txinfo.setText("Details : " + "\n" + info);

            }
        }


    }

    public void share(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, uri );
        intent.putExtra(Intent.EXTRA_TEXT,info);
        intent.setType("image/jpeg");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(intent,"Share News"));

    }

    public void shoot(View view){
        permission_check();

    }
    public void permission_check(){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
        }
        savefile();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        if (requestCode==100 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            savefile();
        }
        else {
            permission_check();
        }
    }

    private void savefile() {
        checkPermissionREAD_EXTERNAL_STORAGE(getApplicationContext());
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = TackScreenshot(scrollView);
                try {
                    if (bitmap != null) {
                        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "titlename", "");
                        Toast.makeText(DetalNews.this,"تم حفظ الصورة ", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                }
            }
        });


    }
    private Bitmap TackScreenshot(View view) {
        Bitmap screenshot = null;
        try {
            int a = view.getMeasuredWidth();
            int b = view.getMeasuredHeight();
            screenshot = Bitmap.createBitmap(a, b, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(screenshot);
            view.draw(c);
        } catch (Exception e) {

        }
        return screenshot;
    }


    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    public boolean checkPermissionREAD_EXTERNAL_STORAGE(
            final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        (Activity) context,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE)) {


                } else {
                    ActivityCompat
                            .requestPermissions(
                                    (Activity) context,
                                    new String[] { android.Manifest.permission.READ_EXTERNAL_STORAGE },
                                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }

        } else {
            return true;
        }
    }


}

