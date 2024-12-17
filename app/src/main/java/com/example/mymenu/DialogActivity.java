package com.example.mymenu;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button dialogButton = findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(v -> showDialog());
    }

    private void showDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Set the title, message, and buttons
        alertDialog.setTitle("Sample Dialog")
                .setMessage("This is an example of an AlertDialog with multiple buttons.");

        // Set actions for the buttons
        alertDialog.setPositiveButton("OK", (dialog, which) -> {
            // Action when OK button is clicked
            dialog.dismiss();
        });

        alertDialog.setNeutralButton("Maybe Later", (dialog, which) -> {
            // Action when Neutral button is clicked
            dialog.dismiss();
        });

        alertDialog.setNegativeButton("Cancel", (dialog, which) -> {
            // Action when Cancel button is clicked
            dialog.dismiss();
        });

        // Show the AlertDialog
        alertDialog.show();
    }
}
