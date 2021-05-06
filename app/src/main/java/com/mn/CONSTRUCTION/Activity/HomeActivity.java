package com.mn.CONSTRUCTION.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mn.CONSTRUCTION.Fragment.OrderFragment;
import com.mn.CONSTRUCTION.R;
import com.mn.CONSTRUCTION.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

;

public class HomeActivity extends BaseActivity {

    private static final String TAG = "HomeActivity" ;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.order:
                    loadFragment(0);
                    return true;
            }
            return false;
        }
    };


    public void loadFragment(int id) {
        Fragment fragment= new OrderFragment();
//        switch (id){
//            case 0:fragment = new Temp_Transaction();break;
//
//            case 1:fragment = new ContactFragment();break;
//            case 2:fragment = new ReportFragment();break;
//            case 3:fragment = new ProfileFragment();break;
//        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}