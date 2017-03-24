package com.govind.krishnachander.day1;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Krishna Chander on 04-07-2016.
 */
public class
MyBroadTest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();

        if(bundle!=null)
        {
            String s=bundle.getString(TelephonyManager.EXTRA_STATE);
            if(s.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                Toast.makeText(context, "CALLER: "+bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
