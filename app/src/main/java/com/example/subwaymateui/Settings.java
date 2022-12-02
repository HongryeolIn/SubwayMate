package com.example.subwaymateui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
        settings_theme_radioGroup.check(UpdateState("SETTINGS_THEME_RADIO_STATE"));
        settings_theme_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.settings_theme_dark:
                        RadioStateSave("SETTINGS_THEME_RADIO_STATE", R.id.settings_theme_dark);
                        ThemeUtil.applyTheme(ThemeUtil.DARK_MODE);
                        ThemeUtil.modSave(getApplicationContext(),ThemeUtil.DARK_MODE);
                        break;
                    case R.id.settings_theme_light:
                        RadioStateSave("SETTINGS_THEME_RADIO_STATE", R.id.settings_theme_light);
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

    private void RadioStateSave(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreferences("theme_radio_state", MODE_PRIVATE); // "radio_state"라는 이름으로 파일생성, MODE_PRIVATE는 자기 앱에서만 사용하도록 설정하는 기본값
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value); // 키와 값을 INT로 저장
        editor.apply(); // 실제로 저장
    }

    private int UpdateState(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("theme_radio_state", MODE_PRIVATE);
        return sharedPreferences.getInt(key, R.id.settings_theme_light);
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