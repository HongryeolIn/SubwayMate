package com.example;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LocaleHelper extends Application {
    public static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    public static String FILE_NAME = "Language_State";


    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;


    public static void setLocale(Activity activity, String langCode) {
        Locale locale = new Locale(langCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());
        persist(activity, langCode);
    }

    private static void persist(Context context, String language) {
        editor = preferences.edit();
        editor.putString(SELECTED_LANGUAGE, language);
        editor.apply();
    }
}