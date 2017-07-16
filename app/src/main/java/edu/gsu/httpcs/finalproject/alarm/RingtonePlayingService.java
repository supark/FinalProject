package edu.gsu.httpcs.finalproject.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import edu.gsu.httpcs.finalproject.AlarmClockActivity;
import edu.gsu.httpcs.finalproject.R;

/**
 * Created by supark on 7/9/17.
 */

public class RingtonePlayingService extends Service{
    private MediaPlayer mediaPlayer;
    private boolean isRunning;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("LocalService","Received start id " + startId + " : " + intent);



        final NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(this, AlarmClockActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Title")
                .setContentText("Text")
                .setContentIntent(pendingIntent)
                .setNumber(10)
                .setTicker("Ticker")
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.COLOR_DEFAULT)
                .setAutoCancel(true)
                .setOngoing(true)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.mipmap.ic_launcher);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        mBuilder.setStyle(bigPictureStyle);
        bigPictureStyle.setBuilder(mBuilder);
        bigPictureStyle.setBigContentTitle("It's time to wake up!!");
        bigPictureStyle.setSummaryText("Get up right now!!");
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.wakeup);
        bigPictureStyle.bigPicture(bitmap1);
        mBuilder.setStyle(bigPictureStyle);

        //fetch the extra string values
        String state = intent.getExtras().getString("extra");

        
        //this converts the extra strings from the intent to start IDs, values 0 or 1
        //assert state != null;
        switch (state) {
            case "on":
                startId = 1;
                break;
            case "off":
                startId = 0;
                Log.e("start ID is ", state);
                break;
            default:
                startId = 0;
                break;
        }

        //Think of many scenarios
        //if there is no music playing, and the user pressed "alarm on", music should start playing
        if(!this.isRunning && startId == 1) {
            Log.e("there is no music", "you want to start");
            mediaPlayer = MediaPlayer.create(this, R.raw.bruno_mars_24k_magic);
            mediaPlayer.start();



            this.isRunning = true;
            startId = 0;
            mNM.notify(0, mBuilder.build());
        }


        //if there is music playing and the user pressed "alarm off", music should stop playing
        else if(this.isRunning && startId == 0) {
            mediaPlayer.stop();
            mediaPlayer.reset();

            this.isRunning = false;
            startId = 0;
        }

        //these are if the user presses random buttons, just to bug-proof the app
        //if there is no music playing, and the user pressed "alarm off", do nothing
        else if(!this.isRunning && startId == 0) {
            Log.e("there is no music", "and you want to end");

            this.isRunning = false;
            startId = 0;
        }

        //if there is music playing and the user pressed "alarm on", do nothing
        else if (this.isRunning && startId == 1) {
            Log.e("there is music", "and you want to start");

            this.isRunning = true;
            startId = 1;
        }

        //can't think of anything else, just to catch the odd event
        else {
            Log.e("else", "somehow you reach this");
        }



        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        Log.e("on Destroy called", "ta da");
        super.onDestroy();
        this.isRunning = false;
    }
}
