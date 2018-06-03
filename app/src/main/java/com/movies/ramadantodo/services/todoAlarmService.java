package com.movies.ramadantodo.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.movies.ramadantodo.BroadCast.todoDismissedReceiver;
import com.movies.ramadantodo.R;
import com.movies.ramadantodo.TodoSettingsActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.paperdb.Paper;

/**
 * Created by user on 4/30/2018.
 */

public class todoAlarmService extends Service {

    ArrayList<Empl> arrPackage;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    UmmalquraCalendar hajreCalendar;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Paper.init(this);
        hajreCalendar = new UmmalquraCalendar();
        sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        hajreCalendar.add(Calendar.DATE, -1);
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); //

        Log.i("cal",cal+"");
        if (cal ==1)
        {
            for (int i=2 ;i<= 30 ;i++)
            {
                editor.putInt("ccounter" + i,  0).apply();
            }
        }
        if (cal ==28)
        {
            editor.putInt("ccounter" + 1,  0).apply();
        }

        int countAfter = sharedPref.getInt("ccounter" + cal, 0);

        arrPackage = new ArrayList<Empl>();
        retriveSharedValue();
        if (cal == 1)
        {
            arrPackage.clear();
            Paper.book().write("setCounter5", arrPackage);
        }
        arrPackage.add(new Empl(countAfter+"",cal));
        Paper.book().write("setCounter5", arrPackage);

        packagesharedPreferences();
        //initHeadLayer();
        PendingIntent pendingIntent = createPendingIntent();

        // Get the layouts to use in the custom notification
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.todo_notific_small);
        notificationLayout.setTextViewText(R.id.notific_count, countAfter +"");

        RemoteViews   notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.todo_notific_larg);
        notificationLayoutExpanded.setTextViewText(R.id.notific_count, countAfter +"");


        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setCustomContentView(notificationLayout)
                        .setCustomBigContentView(notificationLayoutExpanded)
                        .setSmallIcon(R.drawable.ic_sync_black_24dp)
                        .setContentIntent(pendingIntent)
                        .setPriority(Notification.PRIORITY_HIGH)
                        .setDeleteIntent(createOnDismissedIntent(this, 556677))
                        .setAutoCancel(true);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(556677, mBuilder.build());



        //Notification notification = createNotification(pendingIntent);
        //startForeground(FOREGROUND_ID, notification);

        return START_NOT_STICKY;
    }

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    @Override
    public void onDestroy() {
        stopForeground(true);
    }

    private PendingIntent createPendingIntent() {
        Intent intent = new Intent(this, TodoSettingsActivity.class);
        return PendingIntent.getActivity(this, 8976055, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent createOnDismissedIntent(Context context, int notificationId) {
        Intent intent = new Intent(context, todoDismissedReceiver.class);
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(context.getApplicationContext(),
                        notificationId, intent, 0);
        return pendingIntent;
    }

    private void packagesharedPreferences() {
// add elements to al, including duplicates
        Set<Empl> hs = new HashSet<>();
        hs.addAll(arrPackage);
        arrPackage.clear();
        arrPackage.addAll(hs);
        Collections.sort(arrPackage, new  MySorting());
        Paper.book().write("setCounter5", arrPackage);
        Log.d("storesharedPreferences",""+arrPackage);
    }

    private void retriveSharedValue() {
        List<Empl> set2 = Paper.book().read("setCounter5");
        if (set2 != null)
        {
            arrPackage.addAll(set2);
        }
    }

    class MySorting implements Comparator<Empl> {

        @Override
        public int compare(Empl e1,Empl e2) {
            if(e1.getNumber() > e2.getNumber()){
                return 1;
            } else {
                return -1;
            }
        }
    }

    public class Empl{

        private String dailyProgress;
        private int number;

        public Empl(String n, int s){
            this.dailyProgress = n;
            this.number = s;
        }
        public String getName() {
            return dailyProgress;
        }
        public void setName(String name) {
            this.dailyProgress = name;
        }
        public int getNumber() {
            return number;
        }
        public void setSalary(int salary) {
            this.number = salary;
        }
        public String toString(){
            return this.dailyProgress;
        }
    }
}