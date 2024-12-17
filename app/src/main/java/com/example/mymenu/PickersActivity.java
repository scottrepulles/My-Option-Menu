package com.example.mymenu;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class PickersActivity extends AppCompatActivity {
    private TextView tvSelectedDate, tvSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickers);  // Make sure the layout file is correct

        // Initialize the TextViews and Buttons using the correct IDs
        tvSelectedDate = findViewById(R.id.tv_selected_date);
        tvSelectedTime = findViewById(R.id.tv_selected_time);
        Button btnDatePicker = findViewById(R.id.btn_date_picker);
        Button btnTimePicker = findViewById(R.id.btn_time_picker);

        // Set OnClickListeners for the buttons to show pickers
        btnDatePicker.setOnClickListener(v -> showDatePicker());
        btnTimePicker.setOnClickListener(v -> showTimePicker());
    }

    // Method to show the DatePickerDialog
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, month, day) -> {
            String date = day + "/" + (month + 1) + "/" + year;
            tvSelectedDate.setText("Selected Date: " + date);  // Display the selected date
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    // Method to show the TimePickerDialog
    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(this, (view, hour, minute) -> {
            String time = hour + ":" + (minute < 10 ? "0" + minute : minute);  // Format time
            tvSelectedTime.setText("Selected Time: " + time);  // Display the selected time
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
    }
}
