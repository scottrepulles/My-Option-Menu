package com.example.mymenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class AppBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("App Bar with Options Menu");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.option_settings) {
            // Original settings item logic
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (itemId == R.id.option_favorites) {
            // Original favorites item logic
            Toast.makeText(this, "Favorites clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (itemId == R.id.action_settings) {
            // New settings action item logic
            showSettings();
            return true;

        } else if (itemId == R.id.action_favorites) {
            // New favorites action item logic
            showFavorites();
            return true;

        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showSettings() {
        Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
    }

    private void showFavorites() {
        Toast.makeText(this, "Favorites selected", Toast.LENGTH_SHORT).show();
    }
}