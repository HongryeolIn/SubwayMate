package com.example.subwaymateui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.example.LocaleHelper;

public class Settings_Language extends AppCompatActivity {

    private RadioGroup settings_language_radioGroup;
    private ImageButton settings_language_back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_language);

        settings_language_back_button = (ImageButton) findViewById(R.id.settings_language_back_button);
        settings_language_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settings_language_radioGroup = findViewById(R.id.settings_language_radioGroup);
        settings_language_radioGroup.check(UpdateState("SETTINGS_LANGUAGE_RADIO_STATE"));
        settings_language_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int checkedId) {
                switch (checkedId) {
                    case R.id.settings_language_korean_radio:
                        LocaleHelper.setLocale(Settings_Language.this, "ko");
                        RadioStateSave("SETTINGS_LANGUAGE_RADIO_STATE", R.id.settings_language_korean_radio);
                        Log.d("언어설정", "onCheckedChanged: 한국어");
                        break;
                    case R.id.settings_language_English_radio:
                        LocaleHelper.setLocale(Settings_Language.this,"en");
                        RadioStateSave("SETTINGS_LANGUAGE_RADIO_STATE", R.id.settings_language_English_radio);
                        Log.d("언어설정", "onCheckedChanged: 영어");
                        break;
                    case R.id.settings_language_Japanese_radio:
                        LocaleHelper.setLocale(Settings_Language.this,"ja");
                        RadioStateSave("SETTINGS_LANGUAGE_RADIO_STATE", R.id.settings_language_Japanese_radio);
                        Log.d("언어설정", "onCheckedChanged: 일본");
                        break;
                    case R.id.settings_language_Chinese_radio:
                        LocaleHelper.setLocale(Settings_Language.this,"zh");
                        RadioStateSave("SETTINGS_LANGUAGE_RADIO_STATE", R.id.settings_language_Chinese_radio);
                        Log.d("언어설정", "onCheckedChanged: 중국");
                        break;
                }
                reset();
            }
        });
    }

    private void RadioStateSave(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreferences("language_radio_State", MODE_PRIVATE); // "radio_state"라는 이름으로 파일생성, MODE_PRIVATE는 자기 앱에서만 사용하도록 설정하는 기본값
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value); // 키와 값을 INT로 저장
        editor.apply(); // 실제로 저장
    }

    private int UpdateState(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("language_radio_State", MODE_PRIVATE);
        return sharedPreferences.getInt(key, R.id.settings_language_korean_radio);
    }


    private void reset() {
        Intent intent = new Intent(getApplicationContext(), Settings_Language.class);
        intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}