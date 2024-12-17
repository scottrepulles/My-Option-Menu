package com.example.mymenu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PickersActivity extends AppCompatActivity {
    private TextView tvSelectedDate, tvSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickers);  // Correct layout file

        // Initialize the TextViews to display selected date and time
        tvSelectedDate = findViewById(R.id.tv_selected_date);
        tvSelectedTime = findViewById(R.id.tv_selected_time);

        // Initialize buttons for Date and Time pickers
        Button pickDateButton = findViewById(R.id.pickDate);
        Button pickTimeButton = findViewById(R.id.pickTime);

        // Set listeners for the buttons to show the pickers
        pickDateButton.setOnClickListener(v -> {
            DatePickerFragment newFragment = new DatePickerFragment(tvSelectedDate);
            newFragment.show(getSupportFragmentManager(), "datePicker");
        });

        pickTimeButton.setOnClickListener(v -> {
            TimePickerFragment newFragment = new TimePickerFragment(tvSelectedTime);
            newFragment.show(getSupportFragmentManager(), "timePicker");
        });
    }

    // Method to show AlertDialog with confirmation
    private void showConfirmationDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmation")
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> {
                    // Perform any actions when user confirms (optional)
                    Toast.makeText(this, "Confirmed: " + message, Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Optionally handle cancellation (do nothing in this case)
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                })
                .show();
    }

    // Method to show an AlertDialog after selecting a date
    public void onDateSet(String selectedDate) {
        // Show a confirmation dialog with the selected date
        showConfirmationDialog("Selected Date: " + selectedDate);
    }

    // Method to show an AlertDialog after selecting a time
    public void onTimeSet(String selectedTime) {
        // Show a confirmation dialog with the selected time
        showConfirmationDialog("Selected Time: " + selectedTime);
    }
}
