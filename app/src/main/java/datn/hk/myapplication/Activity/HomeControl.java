package datn.hk.myapplication.Activity;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import datn.hk.myapplication.R;


public class HomeControl extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.nav_view)
    BottomNavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_control);


        ButterKnife.bind(this);

        navView.setSelectedItemId(R.id.navigation_house);
         FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_container, new fragment_home()).commit();
        navView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectFragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_accont:
                selectFragment = new fragment_home();
                break;
            case R.id.navigation_house:
                selectFragment = new fragment_home();
                break;
            case R.id.navigation_history:
                selectFragment = new fragment_home();
                break;
        }
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, selectFragment).
                commit();

        return true;
    }


}

