package com.example.yukmangan.presentation.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.yukmangan.R;
import com.example.yukmangan.presentation.home.HomeFragment;
import com.example.yukmangan.presentation.member.MemberFragment;
import com.example.yukmangan.helper.PreferenceHelper;
import com.example.yukmangan.presentation.relawan.RelawanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardAct extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bn_main;
    private PreferenceHelper preferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        preferenceHelper=new PreferenceHelper(this);
        loadFragment(new HomeFragment());
        bn_main=findViewById(R.id.bn_main);
        bn_main.setOnNavigationItemSelectedListener(this);

    }
    public boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragment).commit();
            return true;
        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
       switch (item.getItemId()){
           case R.id.home_menu:
               fragment = new HomeFragment();
               break;
           case R.id.dahboard_menu:

               break;
           case R.id.help_menu:
               fragment = new MemberFragment();
               break;
           case R.id.account_menu:
               //cek doang
                fragment = new RelawanFragment();
               break;
    }
   return loadFragment(fragment);
    }
}
