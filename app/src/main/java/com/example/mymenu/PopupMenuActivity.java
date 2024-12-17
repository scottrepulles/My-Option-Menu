package com.example.mymenu;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PopupMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        // Find the button that will trigger the Popup Menu
        Button button = findViewById(R.id.btn_show_popup);

        // Set the onClickListener to show the PopupMenu when clicked
        button.setOnClickListener(this::showPopupMenu);
    }

    // Method to show the popup menu when the button is clicked
    private void showPopupMenu(View view) {
        // Create the PopupMenu object and inflate the menu from XML
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popupMenu.getMenu());

        // Set the item click listener to handle the menu item clicks
        popupMenu.setOnMenuItemClickListener(this::onMenuItemClick);

        // Show the PopupMenu
        popupMenu.show();
    }

    // Method to handle menu item clicks
    private boolean onMenuItemClick(MenuItem item) {
        // Using if-else to handle the menu item clicks
        int itemId = item.getItemId();

        if (itemId == R.id.popup_option_1) {
            // Handle "Option 1" click
            Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.popup_option_2) {
            // Handle "Option 2" click
            Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            // Default action for other items
            return false;
        }
    }
}
