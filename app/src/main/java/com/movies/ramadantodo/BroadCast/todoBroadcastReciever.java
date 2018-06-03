package com.movies.ramadantodo.BroadCast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.movies.ramadantodo.services.todoAlarmService;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by M.hussien on 4/17/2018.
 */public class todoBroadcastReciever extends WakefulBroadcastReceiver {
    // The app's AlarmManager, which provides access to the system alarm services.
    private AlarmManager alarmMgr;
    // The pending intent that is triggered when the alarm fires.
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, todoAlarmService.class);
        context.startService(intent1);
        setAlarm(context);
    }

    public void setAlarm(Context context) {
        alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, todoBroadcastReciever.class);

        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        now.setTimeInMillis(System.currentTimeMillis());
        // Set the alarm's trigger time to 8:30 a.m.
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(System.currentTimeMillis());
        //calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 58);
        calendar.set(Calendar.SECOND, 0);

        calendar.getTimeInMillis();
        if (calendar.before(now)) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Log.i("DAY_OF_YEAR", "true");
        } else if (calendar.equals(now)) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Log.i("DAY_OF_YEAR==", "true");
        } else if (calendar.getTimeInMillis() <= now.getTimeInMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Log.i("DAY_OF_YEAR<=", "true");
        }

        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,_alarm,2*60*1000,pendingIntent);
        /*Context context = getActivity();
        context.startService(new Intent(context, HeadService.class));*/
        alarmIntent = PendingIntent.getBroadcast(context, 100, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            //lollipop_mr1 is 22, this is only 23 and above
            alarmMgr.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            //JB_MR2 is 18, this is only 19 and above.
            alarmMgr.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        } else {
            //available since api1
            alarmMgr.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        }
    }

    public void cancelAlarm(Context context) {
        // If the alarm has been set, cancel it.
        if (alarmMgr == null) {
            alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        }
        if (alarmMgr != null) {
            if (alarmIntent == null) {
                Intent intent = new Intent(context, todoBroadcastReciever.class);
                alarmIntent = PendingIntent.getBroadcast(context, 123456, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                Log.i("alarmIntent", "cancel");
            }
            alarmIntent.cancel();
            alarmMgr.cancel(alarmIntent);

        }
    }

}
