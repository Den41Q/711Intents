package com.example.a711intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private  Button mBtnSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSync = findViewById(R.id.btn_sync);
    }

    public void synchronization(View view) {
        Intent intent = new Intent(Intent.ACTION_SYNC);
        GregorianCalendar cal = new GregorianCalendar();
        int time = cal.get(Calendar.HOUR_OF_DAY);

        if (time >= 6 && time < 14) {
            intent.setData(Uri.parse("http://morning"));
        } else if (time >= 14 && time < 15) {
            intent.setData(Uri.parse("http://afternoon"));
        } else {
            intent.setData(Uri.parse("http://evening"));
        }
        startActivity(intent);
    }
}
