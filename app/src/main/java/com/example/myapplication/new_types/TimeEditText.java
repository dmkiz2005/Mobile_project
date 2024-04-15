package com.example.myapplication.new_types;

import android.app.TimePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;
import androidx.appcompat.widget.AppCompatEditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimeEditText extends AppCompatEditText {

    private Calendar myCalendar;

    public TimeEditText(Context context) {
        super(context);
        init();
    }

    public TimeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        myCalendar = Calendar.getInstance();

        this.setFocusable(false); // чтобы не показывалась клавиатура при нажатии

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        updateLabel();
    }

    private void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), time, myCalendar
                .get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void updateLabel() {
        String myFormat = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        this.setText(sdf.format(myCalendar.getTime()));
    }

    private TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            myCalendar.set(Calendar.MINUTE, minute);
            updateLabel();
        }
    };

    public String getTimeString() {
        String myFormat = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        return sdf.format(myCalendar.getTime());
    }

    public Calendar getTimeCalendar() {
        return myCalendar;
    }

    public void setTime(Calendar calendar) {
        myCalendar = calendar;
        updateLabel();
    }
}
