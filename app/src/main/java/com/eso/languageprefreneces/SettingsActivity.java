package com.eso.languageprefreneces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.eso.languageprefreneces.LocaleManager.LANGUAGE_ARABIC;
import static com.eso.languageprefreneces.LocaleManager.LANGUAGE_ENGLISH;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findViewById(R.id.en).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale(LANGUAGE_ENGLISH, false);
            }
        });
        findViewById(R.id.en).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return setNewLocale(LANGUAGE_ENGLISH, true);
            }
        });
        findViewById(R.id.ukr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale(LANGUAGE_ARABIC, false);
            }
        });
        findViewById(R.id.ukr).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return setNewLocale(LANGUAGE_ARABIC, true);
            }
        });

    }

    private boolean setNewLocale(String language, boolean restartProcess) {
        MyApplication.localeManager.setNewLocale(this, language);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

        if (restartProcess) {
            System.exit(0);
        } else {
            Toast.makeText(this, "Activity restarted", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
