package com.example;

import android.content.SharedPreferences;

import com.example.subwaymateui.R;

public class RadioStateSaver {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public String FILE_NAME;

    public void setSharedPreferences(android.content.SharedPreferences sp) {
        preferences = sp;
    }

    public void RadioStateSave(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value); // 키와 값을 INT로 저장
        editor.apply(); // 실제로 저장
    }

    public int UpdateState(String key) {
        return preferences.getInt(key, R.id.settings_language_korean_radio);
    }
}
