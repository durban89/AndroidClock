package com.gowhich.androidclock;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private int hourOfDay, minute;
    private int year, monthOfYear, dayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        //获得当前时间，获得小时和分钟
        Calendar calendar = Calendar.getInstance();
        hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new MyTimePickerDialog(), hourOfDay, minute, true);
                timePickerDialog.show();
                break;
            case R.id.button2:
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new MyDatePickerDialog(), year, monthOfYear, dayOfMonth);
                datePickerDialog.show();
                break;
        }
    }

    public class MyTimePickerDialog implements TimePickerDialog.OnTimeSetListener {

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Toast.makeText(MainActivity.this, "hourOfDay: " + i + ", minute:" + i1, Toast.LENGTH_SHORT).show();
        }
    }

    private class MyDatePickerDialog implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Toast.makeText(MainActivity.this, "Year: " + i + ", monthOfYear: " + i1 + ", dayOfMonth:" + i2, Toast.LENGTH_SHORT).show();
        }
    }
}
