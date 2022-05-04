package com.example.hankki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    final String TAG = this.getClass().getSimpleName();
    LinearLayout home_content;
    BottomNavigationView bottomNavigationView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        SettingListener();

        bottomNavigationView.setSelectedItemId(R.id.tab_home);
    }

    private void init() {
        home_content = findViewById(R.id.home_content);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void SettingListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener());
    }

    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.tab_matching: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_content, new MatchingFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_cafeteria: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_content, new CafeteriaFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_home: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_content, new HomeFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_restaurant: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_content, new RestaurantFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_personality: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.home_content, new PersonalFragment())
                            .commit();
                    return true;
                }
            } return false;
        }
    }
}