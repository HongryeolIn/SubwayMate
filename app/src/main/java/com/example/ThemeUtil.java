package com.example;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;

public class ThemeUtil {

    public static final String LIGHT_MODE = "light";
    public static final String DARK_MODE = "dark";
    public static final String DEFAULT_MODE = "default";

    private static final String TAG = "ThemeUtil";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void applyTheme(String themeColor) {
        switch (themeColor) {
            case LIGHT_MODE:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Log.d(TAG,"라이트 모드 적용되어있음");
                break;

            case DARK_MODE:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Log.d(TAG,"다크 모드 적용되어있음");
                break;
        }
    }

    public static void modSave(Context context, String select_mod){
        sharedPreferences = context.getSharedPreferences("mod",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("mod",select_mod);
        editor.apply();
    }

    public static String modLoad(Context context) {
        sharedPreferences = context.getSharedPreferences("mod",context.MODE_PRIVATE);
        String load_mod = sharedPreferences.getString("mod","light");
        return load_mod;
    }
}
