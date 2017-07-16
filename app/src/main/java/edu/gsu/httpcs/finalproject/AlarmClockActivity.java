package edu.gsu.httpcs.finalproject;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
//import android.icu.util.Calendar;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.finalproject.alarm.AlarmReceiver;

import java.util.Calendar;

import static android.icu.util.Calendar.getInstance;
import static edu.gsu.httpcs.finalproject.R.id.timePicker;


@TargetApi(Build.VERSION_CODES.N)
public class AlarmClockActivity extends AppCompatActivity {

    AlarmManager alarmManager;  //make our alarm manager
    Context context;
    final Calendar calendar = Calendar.getInstance();  //create an instance of a calendar

    private PendingIntent pendingIntent;

    @BindView(R.id.update_txt)
    TextView update_txt;


    TimePicker alram_timepicker;
    private Intent intent;

    @OnClick(R.id.go_back_from_alarm)
    public void goBackFromAlarm() {
        Intent intent = new Intent(AlarmClockActivity.this, secondActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.start_alarm)
    public void startBtn() {

        alram_timepicker = (TimePicker) findViewById(timePicker);
        calendar.set(Calendar.HOUR_OF_DAY, alram_timepicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alram_timepicker.getCurrentMinute());


        //get the int values of the hour and minutes
        int hour = alram_timepicker.getCurrentHour();
        int minute = alram_timepicker.getCurrentMinute();

        //convert the int value to strings
        String hour_string = String.valueOf(hour);
        String minute_string = String.valueOf(minute);

        //convert 24-hour time to 12-hour time
        if(hour > 12) {
            hour_string = String.valueOf(hour - 12);
        }
        if(minute < 10) {  //10:07 -> 10:07
            minute_string = "0" + String.valueOf(minute);
        }
        update_txt.setText("Alarm set to " + hour_string +" : " + minute_string);

        //put in extra string into intent tells the clock that you pressed the "alarm on" button
        intent.putExtra("extra", "on");

        //create a pending intent that delays the intent until the specified calendar time
        pendingIntent = PendingIntent.getBroadcast(AlarmClockActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //set the alarm manager
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }


    @OnClick(R.id.end_alarm)
    public void endBtn() {

        update_txt.setText("Alarm off");
//put extra strings into intent tells the clock that you pressed the "alarm off" button
        intent.putExtra("extra" , "off");  //key-value

        //stop the ringtone
        sendBroadcast(intent);//send to AlarmReceiver then AlarmReceiver goes to RingtonePlayingService
        alarmManager.cancel(pendingIntent);

    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmclock);
        ButterKnife.bind(this);

        this.context = this;
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //create an intent to the Alarm Receiver class
        intent = new Intent(this.context, AlarmReceiver.class);

    }



}
