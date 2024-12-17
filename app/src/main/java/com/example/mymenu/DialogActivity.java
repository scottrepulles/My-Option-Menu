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
        new AlertDialog.Builder(this)
                .setTitle("Sample Dialog")
                .setMessage("This is an example of an AlertDialog.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
