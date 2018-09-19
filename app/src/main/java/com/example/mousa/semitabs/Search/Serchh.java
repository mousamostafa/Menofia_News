package com.example.mousa.semitabs.Search;

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
import android.widget.EditText;

import com.example.mousa.semitabs.R;

import java.util.ArrayList;
import java.util.List;

public class Serchh extends AppCompatActivity {
     static EditText srch;
    private Toolbar tolbar;
    static TabLayout tabl;
    private ViewPager viewpg;
    private String[] tabIName = {
            "Top",
            "News Title",
            "News Detail",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        srch = (EditText) findViewById(R.id.txsrche);
        tolbar = (Toolbar) findViewById(R.id.toolbr);
        setSupportActionBar(tolbar);
        viewpg = (ViewPager) findViewById(R.id.viewpagerr);
        setupViewPager(viewpg);
        tabl = (TabLayout) findViewById(R.id.tabss);
        tabl.setupWithViewPager(viewpg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem ite=menu.findItem(R.id.txsrche);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Top_search());
        adapter.addFrag(new Title_search());
        adapter.addFrag(new Detail_search());
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
            return tabIName[position];
        }
    }


}


