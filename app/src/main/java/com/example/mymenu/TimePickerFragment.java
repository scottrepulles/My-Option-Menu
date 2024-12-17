package com.example.mymenu;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private TextView tvSelectedTime;

    // Constructor to pass the TextView from the activity
    public TimePickerFragment(TextView tvSelectedTime) {
        this.tvSelectedTime = tvSelectedTime;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create and return the TimePickerDialog
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Format and display the selected time
        String time = hourOfDay + ":" + (minute < 10 ? "0" + minute : minute);
        tvSelectedTime.setText("Selected Time: " + time);

        // Pass the selected time to the activity to show the confirmation dialog
        ((PickersActivity) getActivity()).onTimeSet(time);
    }
}
