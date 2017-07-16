package edu.gsu.httpcs.finalproject;



import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class StopWatchActivity extends AppCompatActivity {
    int count = 0;

    @BindView(R.id.chronometer)
    Chronometer chronometer;

    @OnClick(R.id.btn_start)
    public void start(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime()); //elapsedRealtime is default one.  Set up the start from 0
        chronometer.start();

    }

    @OnClick(R.id.btn_stop)
    public void stop(View v) {
        chronometer.stop();


    }

    @OnClick(R.id.btn_reset)
    public void reset(View v) {
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        ButterKnife.bind(this);
    }
}
