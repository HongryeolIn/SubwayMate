package com.example.subwaymateui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings_Update extends AppCompatActivity {

    private ImageButton settings_update_back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_update);

        settings_update_back_button = (ImageButton) findViewById(R.id.settings_update_back_button);
        settings_update_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}