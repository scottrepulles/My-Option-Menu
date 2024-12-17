package com.example.mymenu;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private final TextView tvSelectedDate;

    // Constructor to pass the TextView from the activity
    public DatePickerFragment(TextView tvSelectedDate) {
        this.tvSelectedDate = tvSelectedDate;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create and return the DatePickerDialog
        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Format and display the selected date
        String date = day + "/" + (month + 1) + "/" + year;
        tvSelectedDate.setText("Selected Date: " + date);

        // Pass the selected date to the activity to show the confirmation dialog
        ((PickersActivity) getActivity()).onDateSet(date);
    }
}
