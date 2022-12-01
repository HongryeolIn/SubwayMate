package com.example.subwaymateui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.example.ThemeUtil;

public class Settings extends AppCompatActivity {

    private ImageButton settings_back_button;
    private Button settings_update_button;
    private Button settings_language_button;
    private Button settings_excludeRoute_button;
    private RadioGroup settings_theme_radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTheme(R.style.Theme_SubwayMateUI);

        settings_theme_radioGroup = findViewById(R.id.settings_theme_radioGroup);
        settings_theme_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.settings_theme_dark:
                        ThemeUtil.applyTheme(ThemeUtil.DARK_MODE);
                        ThemeUtil.modSave(getApplicationContext(),ThemeUtil.DARK_MODE);
                        break;
                    case R.id.settings_theme_light:
                        ThemeUtil.applyTheme(ThemeUtil.LIGHT_MODE);
                        ThemeUtil.modSave(getApplicationContext(),ThemeUtil.LIGHT_MODE);
                        break;
                }
                reset();
            }
        });

        settings_back_button = (ImageButton) findViewById(R.id.settings_back_button);
        settings_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settings_language_button = (Button) findViewById(R.id.settings_language_button);
        settings_language_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings_Language.class);
                startActivity(intent);
            }
        });
        settings_update_button = (Button) findViewById(R.id.settings_update_button);
        settings_update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings_Update.class);
                startActivity(intent);
            }
        });
        settings_excludeRoute_button = (Button) findViewById(R.id.settings_excludeRoute_button);
        settings_excludeRoute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings_ExcludeRoute.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
    private void reset() {
        Intent intent = new Intent(getApplicationContext(), Settings.class);
        intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}