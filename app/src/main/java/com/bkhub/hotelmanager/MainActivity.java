package com.bkhub.hotelmanager;

import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView txt_year, txtyear1, txt_md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();


    }

    private void init() {
        txt_year = (TextView) findViewById(R.id.txt_nam);
        txtyear1 = (TextView) findViewById(R.id.txt_nam1);
        txt_md = (TextView) findViewById(R.id.txt_thu_thang);


    }

    private void addListener() {
        Date mdate = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 10);
        CalendarPickerView datapv = (CalendarPickerView) findViewById(R.id.pv_calendar);
        datapv.init(mdate, nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.RANGE).withSelectedDate(mdate);


        datapv.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                String myear = " " + calendar.get(Calendar.YEAR);
                txt_year.setText(myear);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
                String mthu = simpleDateFormat.format(calendar.getTime());

                SimpleDateFormat simplemdate = new SimpleDateFormat("dd");
                String mdate = simplemdate.format(calendar.getTime());

                SimpleDateFormat simplemMonth = new SimpleDateFormat("MM");
                String mMonth = simplemMonth.format(calendar.getTime());
                String mdaymonth = mthu + ", " + mdate + " thg " + mMonth;
                txt_md.setText(mdaymonth);


            }

            @Override
            public void onDateUnselected(Date date) {


            }
        });

    }


}
