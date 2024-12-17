package com.example.mymenu;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation(R.id.btn_app_bar, AppBarActivity.class);
        setupNavigation(R.id.btn_contextual_menu, ContextMenuActivity.class);
        setupNavigation(R.id.btn_popup_menu, PopupMenuActivity.class);
        setupNavigation(R.id.btn_dialogs, DialogActivity.class);
        setupNavigation(R.id.btn_pickers, PickersActivity.class);
    }

    private void setupNavigation(int buttonId, Class<?> activityClass) {
        findViewById(buttonId).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activityClass);
            startActivity(intent);
        });
    }
}
