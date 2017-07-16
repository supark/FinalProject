package edu.gsu.httpcs.finalproject.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by supark on 7/9/17.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("We are in the receiver","Yay!");

        //fetch extra strings from the intent
        String state = intent.getExtras().getString("extra");

        Log.e("What is the key?", state);

        //create an intent to the ringtone service
        Intent serviceIntent = new Intent(context, RingtonePlayingService.class);

        //pass the extra string from AlarmClockActivity to the Ringtone playing service
        serviceIntent.putExtra("extra",state);

        //start the ringtone service
        context.startService(serviceIntent);

    }
}
