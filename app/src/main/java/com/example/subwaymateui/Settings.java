package com.example.subwaymateui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {

    private ImageButton settings_back_button;
    private Button settings_theme_button;
    private Button settings_language_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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
        settings_theme_button = (Button) findViewById(R.id.settings_update_button);
        settings_theme_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), settings_Language.class);
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}