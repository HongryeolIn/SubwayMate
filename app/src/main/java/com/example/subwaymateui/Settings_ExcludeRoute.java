package com.example.subwaymateui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings_ExcludeRoute extends AppCompatActivity {

    private ImageButton settings_excludeRoute_back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_exclude_route);

        settings_excludeRoute_back_button = (ImageButton) findViewById(R.id.settings_excludeRoute_back_button);
        settings_excludeRoute_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}