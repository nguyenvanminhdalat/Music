package com.music.mainapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout mainframe;
    BottomNavigationView bottomNavigationView;
    OfflineFragment offlineFragment;
    OnlineFragment onlineFragment;
    ChartFragment chartFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottomBar);
        mainframe= (FrameLayout) findViewById(R.id.mainframe);
        offlineFragment=new OfflineFragment();
        onlineFragment =new OnlineFragment();
        chartFragment=new ChartFragment();
        setFragment(offlineFragment);
        setContentView(R.layout.activity_main);
        addControl();
    }

    private void addControl() {
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_offline:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(offlineFragment);
                        return true;
                    case R.id.action_online:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(onlineFragment);
                        return true;
                    case R.id.action_chart:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(chartFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();
    }
}
