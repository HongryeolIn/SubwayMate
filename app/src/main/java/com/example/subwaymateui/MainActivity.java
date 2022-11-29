package com.example.subwaymateui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.LocaleHelper;
import com.example.ThemeUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.subwaymateui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeUtil.applyTheme(ThemeUtil.modLoad(MainActivity.this));

        LocaleHelper.preferences = getSharedPreferences(LocaleHelper.FILE_NAME, Activity.MODE_PRIVATE);
        LocaleHelper.setLocale(MainActivity.this, LocaleHelper.preferences.getString(LocaleHelper.SELECTED_LANGUAGE, "ko"));

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_community, R.id.navigation_statistics)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

        if(isFirst == true) {
            //to apply current language or theme at the first run
            Log.d("isFirst: true", "onCreate: in isFirst==true conditional statement");
            isFirst = false;
            recreate();
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public void onBackPressed() {
        final long finishtimeed = 1000;
        long presstime = 0;
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - presstime;

        if (0 <= intervalTime && finishtimeed >= intervalTime)
            finish();
        else {
            presstime = tempTime;
            Toast.makeText(getApplicationContext(), "한번더 누르시면 앱이 종료됩니다", Toast.LENGTH_SHORT).show();
        }
    }

}