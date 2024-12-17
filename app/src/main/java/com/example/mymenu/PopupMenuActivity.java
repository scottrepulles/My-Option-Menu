package com.example.mymenu;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.ScaleAnimation;
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
        button.setOnClickListener(view -> {
            // Add a scale-up animation
            applyScaleUpAnimation(view);
            // Show the popup menu
            showPopupMenu(view);
        });
    }

    // Method to apply scale-up animation
    private void applyScaleUpAnimation(View view) {
        ScaleAnimation scaleUp = new ScaleAnimation(
                1.0f, 1.1f,  // Start and end scale on X-axis
                1.0f, 1.1f,  // Start and end scale on Y-axis
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,  // Pivot point X
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f   // Pivot point Y
        );
        scaleUp.setDuration(200);
        view.startAnimation(scaleUp);
    }

    // Method to show the popup menu when the button is clicked
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popupMenu.getMenu());

        // Set the item click listener to handle the menu item clicks
        popupMenu.setOnMenuItemClickListener(this::onMenuItemClick);

        popupMenu.show();
    }

    // Method to handle menu item clicks
    private boolean onMenuItemClick(MenuItem item) {
        return handlePopupMenuItemClick(item);
    }

    // Common method to perform actions for each popup menu item
    private boolean handlePopupMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.popup_option_1) {
            Toast.makeText(this, "Blue? Red? Maybe Yellow? Great choice!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.popup_option_2) {
            Toast.makeText(this, "Dreaming of Paris, Tokyo, or the Maldives? Go for it!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.option_forward) {
            Toast.makeText(this, "Super strength or flying? Both sound awesome!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
}
