package com.movies.ramadantodo.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.movies.ramadantodo.services.todoAlarmService;

/**
 * Created by user on 5/1/2018.
 */

public class todoDismissedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.stopService(new Intent(context, todoAlarmService.class));
    }
}
