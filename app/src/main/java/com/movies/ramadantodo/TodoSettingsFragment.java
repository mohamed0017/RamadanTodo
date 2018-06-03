package com.movies.ramadantodo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;

import android.widget.Toast;

import com.movies.ramadantodo.BroadCast.todoBroadcastReciever;

/**
 * Created by M.hussien on 4/29/2018.
 */

public class TodoSettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    public SwitchPreference testPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);

        testPref = (SwitchPreference) findPreference("alarm_switch"); //Preference Key

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean test = preferences.getBoolean("alarm_switch", true);

        if (test) {
            testPref.setSummary("تم التشغيل");
        } else {
            testPref.setSummary("لم يتم التشغيل");
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("alarm_switch")) {
            boolean test = sharedPreferences.getBoolean("alarm_switch", false);
            //Do whatever you want here. This is an paradies.
            if (test) {
                testPref.setSummary("تم التشغيل");
                Toast.makeText(getActivity(), "سيتم تشغيل الاشعارات تصل يوميا الساعة 11:59 مساء ", Toast.LENGTH_SHORT).show();
                todoBroadcastReciever alarmBroadcastReciever = new todoBroadcastReciever();
                alarmBroadcastReciever.setAlarm(getActivity());

            } else {
                testPref.setSummary("لم يتم التشغيل ");
                todoBroadcastReciever alarmBroadcastReciever = new todoBroadcastReciever();
                alarmBroadcastReciever.cancelAlarm(getActivity());
            }

        }
    }


    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);


    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
