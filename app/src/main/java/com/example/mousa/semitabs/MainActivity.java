package com.example.mousa.semitabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mousa.semitabs.Adapters.Recycl_Adapter;
import com.example.mousa.semitabs.Fragments.fragment_Home;
import com.example.mousa.semitabs.Fragments.fragment_Notification;
import com.example.mousa.semitabs.Fragments.fragment_degree;
import com.example.mousa.semitabs.Fragments.fragment_menu;
import com.example.mousa.semitabs.Search.Serchh;

import java.util.ArrayList;
import java.util.List;

import static com.example.mousa.semitabs.Mybrodcast.flog;

public class MainActivity extends AppCompatActivity {
    public static Button searh;
    fragment_Home fragment_home = new fragment_Home();
    Recycl_Adapter mAdapter;
    ArrayList<String> searchlist = new ArrayList<String>();
    ArrayAdapter<String> ArrayAdpt;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
   public static TextView textView;
   public static TextView text;

    private int[] tabIcons = {
            R.drawable.hom,
            R.drawable.grad,
            R.drawable.ic_notifications_black_24dp,
            R.drawable.ic_menu_black_24dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(flog==1){
            Toast.makeText(getApplicationContext(),"Network connected",Toast.LENGTH_SHORT).show();

        }
        else if(flog==2){
            Toast.makeText(getApplicationContext(),"There's no network connectivity",Toast.LENGTH_SHORT).show();

        }
        textView=(TextView)findViewById(R.id.tx);
        text=(TextView)findViewById(R.id.textView);
        Intent in=new Intent(this,Mybrodcast.class);
        sendBroadcast(in);
        searh = (Button) findViewById(R.id.txsrch);
        searh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Serchh.class);
                startActivity(intent);
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem ite=menu.findItem(R.id.txsrch);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new fragment_Home());
        adapter.addFrag(new fragment_degree());
        adapter.addFrag(new fragment_Notification());
        adapter.addFrag(new fragment_menu());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

}

