package com.movies.ramadantodo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.movies.ramadantodo.BroadCast.todoBroadcastReciever;
import com.movies.ramadantodo.adapter.progressAdapter;
import com.movies.ramadantodo.services.todoAlarmService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.paperdb.Paper;

/**
 * Created by M.hussien on 4/25/2018.
 */

public class TodoMainActivity extends AppCompatActivity {

    @BindView(R.id.jama3a)
    RadioButton jama3a;
    @BindView(R.id.alone)
    RadioButton alone;
    @BindView(R.id.late)
    RadioButton late;
    @BindView(R.id.jama3a1)
    RadioButton jama3a1;
    @BindView(R.id.alone1)
    RadioButton alone1;
    @BindView(R.id.late1)
    RadioButton late1;
    @BindView(R.id.jama3a3)
    RadioButton jama3a3;
    @BindView(R.id.alone3)
    RadioButton alone3;
    @BindView(R.id.late2)
    RadioButton late3;
    @BindView(R.id.jama3a4)
    RadioButton jama3a4;
    @BindView(R.id.alone4)
    RadioButton alone4;
    @BindView(R.id.late4)
    RadioButton late4;
    @BindView(R.id.jama3a5)
    RadioButton jama3a5;
    @BindView(R.id.alone5)
    RadioButton alone5;
    @BindView(R.id.late5)
    RadioButton late5;
    @BindView(R.id.radioQurn1)
    RadioButton radioQurn1;
    @BindView(R.id.radioQurn2)
    RadioButton radioQurn2;
    @BindView(R.id.radioQurn3)
    RadioButton radioQurn3;
    @BindView(R.id.radioYesAm)
    RadioButton radioYesAm;
    @BindView(R.id.radioNosAm)
    RadioButton radioNosAm;
    @BindView(R.id.radioYesPm)
    RadioButton radioYesPm;
    @BindView(R.id.radioNosPm)
    RadioButton radioNosPm;
    @BindView(R.id.radioTasbe7More)
    RadioButton radioTasbe7More;
    @BindView(R.id.radioTasbe7Less)
    RadioButton radioTasbe7Less;
    @BindView(R.id.radioTasbe7No)
    RadioButton radioTasbe7No;
    @BindView(R.id.radioazkarastagfarMore)
    RadioButton radioazkarastagfarMore;
    @BindView(R.id.radioazkarastagfarLess)
    RadioButton radioazkarastagfarLess;
    @BindView(R.id.radioazkarastagfarNo)
    RadioButton radioazkarastagfarNo;
    @BindView(R.id.radioazkarSalahMore)
    RadioButton radioazkarSalahMore;
    @BindView(R.id.radioazkarSalahLess)
    RadioButton radioazkarSalahLess;
    @BindView(R.id.radioazkarSalahNo)
    RadioButton radioazkarSalahNo;
    @BindView(R.id.radioTarawehsalahMore)
    RadioButton radioTarawehsalahMore;
    @BindView(R.id.radioTarawehsalahLess)
    RadioButton radioTarawehsalahLess;
    @BindView(R.id.radioTarawehsalahNo)
    RadioButton radioTarawehsalahNo;
    @BindView(R.id.radioSadakaYes)
    RadioButton radioSadakaYes;
    @BindView(R.id.radioSadakaNo)
    RadioButton radioSadakaNo;
    @BindView(R.id.fajrBox)
    CheckBox fajrCheck;
    @BindView(R.id.dohrBox)
    CheckBox dohrBox;
    @BindView(R.id.asrBox)
    CheckBox asrBox;
    @BindView(R.id.magrebrBox)
    CheckBox magrebrBox;
    @BindView(R.id.ishaBox)
    CheckBox ishaBox;
    @BindView(R.id.fajrLinerar)
    LinearLayout fajrRow;
    @BindView(R.id.dohrLinerar)
    LinearLayout dohrRow;
    @BindView(R.id.asrLinerar)
    LinearLayout asrRow;
    @BindView(R.id.magrebLinerar)
    LinearLayout magrbRow;
    @BindView(R.id.ishaLinerar)
    LinearLayout ishaRow;
    @BindView(R.id.quranLinerar)
    LinearLayout quranRow;
    @BindView(R.id.sadakaLinerar)
    LinearLayout sadakaRow;
    @BindView(R.id.tarawehLinerar)
    LinearLayout tarawehRow;
    @BindView(R.id.tasbe7Linear)
    LinearLayout tasbehRow;
    @BindView(R.id.ast9farLinerar)
    LinearLayout astgfarRow;
    @BindView(R.id.salahLinerar)
    LinearLayout salahRow;
    @BindView(R.id.azkarLinerar)
    LinearLayout azkarAmRow;
    @BindView(R.id.azkarLinerarPm)
    LinearLayout azkarPmRow;
    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.azkarText)
    TextView azkarText;
    @BindView(R.id.quranText)
    TextView quranText;
    @BindView(R.id.salahText)
    TextView salahText;
    @BindView(R.id.titlelProgress)
    TextView titlelProgress;
    @BindView(R.id.PetsentProgress)
    LinearLayout PetsentProgress;

    ProgressBar Progressbar;
    TextView ShowText;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    UmmalquraCalendar hajreCalendar;
    ArrayList<todoAlarmService.Empl> arrPackage;
    progressAdapter progressAdapter2;
    private TextView mTextMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity_navegation_top);

        Paper.init(this);
        arrPackage =new ArrayList<>();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(navigation);

        Progressbar = (ProgressBar) findViewById(R.id.progressBar1);
        ShowText = (TextView) findViewById(R.id.textViewProgress);
        hajreCalendar = new UmmalquraCalendar();
        hajreCalendar.add(Calendar.DATE, -1);
        sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        String firsttime= sharedPref.getString("firsttime2","0");
        if (firsttime.equals("0"))
        {
            todoBroadcastReciever alarmBroadcastReciever = new todoBroadcastReciever();
            alarmBroadcastReciever.setAlarm(this);
            editor.putString("firsttime2","1").apply();
        }
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        int countBeore = sharedPref.getInt("ccounter" + cal, 0);
        Progressbar.setProgress(countBeore);
        ShowText.setText(countBeore + "");
        retriveSharedValue();
        // bind the view using butterknife
        ButterKnife.bind(this);
        sonaBoxes();
        fajrCheck();
        asrCheck();
        magrebCheck();
        ishaCheck();
        quranCheck();
        AzkarAm();
        AzkarPm();
        Tasbe7Method();
        astagfarMethod();
        SalahMethod();
        TarawehMethod();
        Sadaka();

        azkarAmRow.setVisibility(View.GONE);
        azkarPmRow.setVisibility(View.GONE);
        tasbehRow.setVisibility(View.GONE);
        astgfarRow.setVisibility(View.GONE);
        salahRow.setVisibility(View.GONE);
        quranRow.setVisibility(View.GONE);
        tarawehRow.setVisibility(View.VISIBLE);
        sadakaRow.setVisibility(View.GONE);
        azkarText.setVisibility(View.GONE);
        quranText.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressAdapter2= new progressAdapter(this, arrPackage);
        // Assign adapter to ListView
        recyclerView.setAdapter(progressAdapter2);
        recyclerView.setVisibility(View.GONE);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fajrRow.setVisibility(View.VISIBLE);
                    dohrRow.setVisibility(View.VISIBLE);
                    asrRow.setVisibility(View.VISIBLE);
                    magrbRow.setVisibility(View.VISIBLE);
                    ishaRow.setVisibility(View.VISIBLE);
                    salahText.setVisibility(View.VISIBLE);

                    recyclerView.setVisibility(View.GONE);
                    azkarAmRow.setVisibility(View.GONE);
                    azkarPmRow.setVisibility(View.GONE);
                    tasbehRow.setVisibility(View.GONE);
                    astgfarRow.setVisibility(View.GONE);
                    salahRow.setVisibility(View.GONE);
                    quranRow.setVisibility(View.GONE);
                    tarawehRow.setVisibility(View.VISIBLE);
                    sadakaRow.setVisibility(View.GONE);
                    azkarText.setVisibility(View.GONE);
                    quranText.setVisibility(View.GONE);
                    Progressbar.setVisibility(View.VISIBLE);
                    ShowText.setVisibility(View.VISIBLE);
                    titlelProgress.setVisibility(View.VISIBLE);
                    PetsentProgress.setVisibility(View.VISIBLE);

                    return true;
                case R.id.navigation_dashboard:
                    azkarAmRow.setVisibility(View.VISIBLE);
                    azkarPmRow.setVisibility(View.VISIBLE);
                    tasbehRow.setVisibility(View.VISIBLE);
                    astgfarRow.setVisibility(View.VISIBLE);
                    salahRow.setVisibility(View.VISIBLE);
                    azkarText.setVisibility(View.VISIBLE);

                    fajrRow.setVisibility(View.GONE);
                    dohrRow.setVisibility(View.GONE);
                    asrRow.setVisibility(View.GONE);
                    magrbRow.setVisibility(View.GONE);
                    ishaRow.setVisibility(View.GONE);
                    quranRow.setVisibility(View.GONE);
                    tarawehRow.setVisibility(View.GONE);
                    sadakaRow.setVisibility(View.GONE);
                    quranText.setVisibility(View.GONE);
                    salahText.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    Progressbar.setVisibility(View.VISIBLE);
                    ShowText.setVisibility(View.VISIBLE);
                    titlelProgress.setVisibility(View.VISIBLE);
                    PetsentProgress.setVisibility(View.VISIBLE);

                    return true;
                case R.id.navigation_notifications:
                    azkarAmRow.setVisibility(View.GONE);
                    azkarPmRow.setVisibility(View.GONE);
                    tasbehRow.setVisibility(View.GONE);
                    astgfarRow.setVisibility(View.GONE);
                    salahRow.setVisibility(View.GONE);
                    quranText.setVisibility(View.VISIBLE);

                    fajrRow.setVisibility(View.GONE);
                    dohrRow.setVisibility(View.GONE);
                    asrRow.setVisibility(View.GONE);
                    magrbRow.setVisibility(View.GONE);
                    ishaRow.setVisibility(View.GONE);
                    azkarText.setVisibility(View.GONE);
                    salahText.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                    quranRow.setVisibility(View.VISIBLE);
                    tarawehRow.setVisibility(View.GONE);
                    sadakaRow.setVisibility(View.VISIBLE);
                    Progressbar.setVisibility(View.VISIBLE);
                    ShowText.setVisibility(View.VISIBLE);
                    titlelProgress.setVisibility(View.VISIBLE);
                    PetsentProgress.setVisibility(View.VISIBLE);
                    return true;
                case R.id.progress_tab:
                    if (arrPackage.isEmpty())
                    {
                        Toast.makeText(TodoMainActivity.this, "لم يتم اضافة التقيم اليومي حتي الان يتم اضافة التقييم مع نهاية اليوم!!", Toast.LENGTH_LONG).show();
                    }
                    recyclerView.setVisibility(View.VISIBLE);

                    azkarAmRow.setVisibility(View.GONE);
                    azkarPmRow.setVisibility(View.GONE);
                    tasbehRow.setVisibility(View.GONE);
                    astgfarRow.setVisibility(View.GONE);
                    salahRow.setVisibility(View.GONE);

                    fajrRow.setVisibility(View.GONE);
                    dohrRow.setVisibility(View.GONE);
                    asrRow.setVisibility(View.GONE);
                    magrbRow.setVisibility(View.GONE);
                    ishaRow.setVisibility(View.GONE);
                    quranText.setVisibility(View.GONE);
                    salahText.setVisibility(View.GONE);
                    azkarText.setVisibility(View.GONE);
                    quranRow.setVisibility(View.GONE);
                    tarawehRow.setVisibility(View.GONE);
                    sadakaRow.setVisibility(View.GONE);
                    ShowText.setVisibility(View.GONE);
                    Progressbar.setVisibility(View.GONE);
                    titlelProgress.setVisibility(View.GONE);
                    PetsentProgress.setVisibility(View.GONE);
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.setting) {
            Intent intent = new Intent(this, TodoSettingsActivity.class);
            intent.setAction("main_settings");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sonaBoxes() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        if (sharedPref.getInt("fajrCheck" + cal, 0) == 1)
            fajrCheck.setChecked(true);
        if (sharedPref.getInt("dohrBox" + cal, 0) == 1)
            dohrBox.setChecked(true);
        if (sharedPref.getInt("asrBox" + cal, 0) == 1)
            asrBox.setChecked(true);
        if (sharedPref.getInt("magrebrBox" + cal, 0) == 1)
            magrebrBox.setChecked(true);
        if (sharedPref.getInt("ishaBox" + cal, 0) == 1)
            ishaBox.setChecked(true);
    }

    //Fajr Salah
    public void fajrCheck() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("fajr_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            jama3a.setChecked(true);
            alone.setChecked(false);
            late.setChecked(false);
        } else if (jama3a_str_0.equals("2")) {
            jama3a.setChecked(false);
            alone.setChecked(true);
            late.setChecked(false);
        } else if (jama3a_str_0.equals("1")) {
            jama3a.setChecked(false);
            alone.setChecked(false);
            late.setChecked(true);
        } else {
            Log.i("fajr_error", "error");

        }

        jama3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("fajr_salah" + cal, "0");

                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }

                if (!jama3a_str_checer.equals("3")) {
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 8).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putString("fajr_salah" + cal, "3").apply();
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار بالفعل !! ", Toast.LENGTH_SHORT).show();
            }
        });
        alone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("fajr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();
                } else if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                }

                if (!jama3a_str_checer.equals("2")) {
                    editor.putString("fajr_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);

                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();

            }
        });
        late.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("fajr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("fajr_salah" + cal, "1").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("1"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });

        fajrCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fajrCheck.isChecked()) {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("fajrCheck" + cal, 1).apply();

                } else {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count - 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("fajrCheck" + cal, 0).apply();

                }
            }
        });

        duhrCheck();
    }

    // Duhr Salah
    public void duhrCheck() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("duhr_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            jama3a1.setChecked(true);
            alone1.setChecked(false);
            late1.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            jama3a1.setChecked(false);
            alone1.setChecked(true);
            late1.setChecked(false);
        }
        if (jama3a_str_0.equals("1")) {
            jama3a1.setChecked(false);
            alone1.setChecked(false);
            late1.setChecked(true);
        } else {
            Log.i("duhr_error", "error");
        }


        jama3a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("duhr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("duhr_salah" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 8).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        alone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("duhr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();


                } else if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("duhr_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        late1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("duhr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("duhr_salah" + cal, "1").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dohrBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dohrBox.isChecked()) {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("dohrBox" + cal, 1).apply();


                } else {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count - 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("dohrBox" + cal, 0).apply();

                }
            }
        });
    }

    //Asr Salah
    public void asrCheck() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("asr_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            jama3a3.setChecked(true);
            alone3.setChecked(false);
            late3.setChecked(false);
        }
        String jama3a_str_1 = sharedPref.getString("asr_salah" + cal, "0");
        if (jama3a_str_1.equals("2")) {
            jama3a3.setChecked(false);
            alone3.setChecked(true);
            late3.setChecked(false);
        }
        String jama3a_str = sharedPref.getString("asr_salah" + cal, "0");
        if (jama3a_str.equals("1")) {
            jama3a3.setChecked(false);
            alone3.setChecked(false);
            late3.setChecked(true);
        } else {
            Log.i("asr_salah", "error");
        }

        jama3a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("asr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("asr_salah" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 8).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        alone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("asr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();


                } else if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("asr_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        late3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("asr_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("asr_salah" + cal, "1").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        asrBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (asrBox.isChecked()) {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("asrBox" + cal, 1).apply();


                } else {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count - 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("asrBox" + cal, 0).apply();

                }
            }
        });
    }

    //Magreb Salah
    public void magrebCheck() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("magreb_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            jama3a4.setChecked(true);
            alone4.setChecked(false);
            late4.setChecked(false);
        }
        String jama3a_str_1 = sharedPref.getString("magreb_salah" + cal, "0");
        if (jama3a_str_1.equals("2")) {
            jama3a4.setChecked(false);
            alone4.setChecked(true);
            late4.setChecked(false);
        }
        String jama3a_str = sharedPref.getString("magreb_salah" + cal, "0");
        if (jama3a_str.equals("1")) {
            jama3a4.setChecked(false);
            alone4.setChecked(false);
            late4.setChecked(true);
        } else {
            Log.i("magreb_salah", "error");
        }

        jama3a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("magreb_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("magreb_salah" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 8).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        alone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("magreb_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();
                } else if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("magreb_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        late4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("magreb_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("magreb_salah" + cal, "1").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        magrebrBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (magrebrBox.isChecked()) {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("magrebrBox" + cal, 1).apply();
                } else {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count - 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("magrebrBox" + cal, 0).apply();

                }
            }
        });
    }

    //  Isha Salah
    public void ishaCheck() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("isha_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            jama3a5.setChecked(true);
            alone5.setChecked(false);
            late5.setChecked(false);
        }
        String jama3a_str_1 = sharedPref.getString("isha_salah" + cal, "0");
        if (jama3a_str_1.equals("2")) {
            jama3a5.setChecked(false);
            alone5.setChecked(true);
            late5.setChecked(false);
        }
        String jama3a_str = sharedPref.getString("isha_salah" + cal, "0");
        if (jama3a_str.equals("1")) {
            jama3a5.setChecked(false);
            alone5.setChecked(false);
            late5.setChecked(true);
        } else {
            Log.i("isha_salah", "error");
        }

        jama3a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("isha_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("isha_salah" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 8).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        alone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("isha_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();
                } else if (jama3a_str_checer.equals("1")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("isha_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        late5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("isha_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 8);
                    ShowText.setText(countBeore - 8 + "");
                    editor.putInt("ccounter" + cal, countBeore - 8).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("isha_salah" + cal, "1").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ishaBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ishaBox.isChecked()) {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 5);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("ishaBox" + cal, 1).apply();

                } else {
                    int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count - 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 5);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                    editor.putInt("ishaBox" + cal, 0).apply();

                }
            }
        });
    }


    //  Quran
    public void quranCheck() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("quran_ward" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioQurn1.setChecked(true);
            radioQurn2.setChecked(false);
            radioQurn3.setChecked(false);
        }
        String jama3a_str_1 = sharedPref.getString("quran_ward" + cal, "0");
        if (jama3a_str_1.equals("2")) {
            radioQurn1.setChecked(false);
            radioQurn2.setChecked(true);
            radioQurn3.setChecked(false);
        }
        String jama3a_str = sharedPref.getString("quran_ward" + cal, "0");
        if (jama3a_str.equals("1")) {
            radioQurn1.setChecked(false);
            radioQurn2.setChecked(false);
            radioQurn3.setChecked(true);
        } else {
            Log.i("quran_ward", "error");
        }

        radioQurn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("quran_ward" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("quran_ward" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 10).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioQurn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("quran_ward" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 10);
                    ShowText.setText(countBeore - 10 + "");
                    editor.putInt("ccounter" + cal, countBeore - 10).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("quran_ward" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        radioQurn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("quran_ward" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 10);
                    ShowText.setText(countBeore - 10 + "");
                    editor.putInt("ccounter" + cal, countBeore - 10).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("quran_ward" + cal, "1").apply();

                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //AzkarAm
    public void AzkarAm() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("AzkarAm" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioYesAm.setChecked(true);
            radioNosAm.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioYesAm.setChecked(false);
            radioNosAm.setChecked(true);
        }

        radioYesAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("AzkarAm" + cal, "0");

                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("AzkarAm" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioNosAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("AzkarAm" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("AzkarAm" + cal, "2").apply();

                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //AzkarAm
    public void AzkarPm() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("AzkarPm" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioYesPm.setChecked(true);
            radioNosPm.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioYesPm.setChecked(false);
            radioNosPm.setChecked(true);
        }

        radioYesPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("AzkarPm" + cal, "0");

                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("AzkarPm" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioNosPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("AzkarPm" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("AzkarPm" + cal, "2").apply();

                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //  Tasbe7
    public void Tasbe7Method() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("Tasbe7" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioTasbe7More.setChecked(true);
            radioTasbe7Less.setChecked(false);
            radioTasbe7No.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioTasbe7More.setChecked(false);
            radioTasbe7Less.setChecked(true);
            radioTasbe7No.setChecked(false);
        }
        if (jama3a_str_0.equals("1")) {
            radioTasbe7More.setChecked(false);
            radioTasbe7Less.setChecked(false);
            radioTasbe7No.setChecked(true);
        }

        radioTasbe7More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Tasbe7" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("Tasbe7" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioTasbe7Less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Tasbe7" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("Tasbe7" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        radioTasbe7No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Tasbe7" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("Tasbe7" + cal, "1").apply();

                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //  استغفار
    public void astagfarMethod() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("astagfar" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioazkarastagfarMore.setChecked(true);
            radioazkarastagfarLess.setChecked(false);
            radioazkarastagfarNo.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioazkarastagfarMore.setChecked(false);
            radioazkarastagfarLess.setChecked(true);
            radioazkarastagfarNo.setChecked(false);
        }
        if (jama3a_str_0.equals("1")) {
            radioazkarastagfarMore.setChecked(false);
            radioazkarastagfarLess.setChecked(false);
            radioazkarastagfarNo.setChecked(true);
        }

        radioazkarastagfarMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("astagfar" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("astagfar" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioazkarastagfarLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("astagfar" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("astagfar" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        radioazkarastagfarNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("astagfar" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("astagfar" + cal, "1").apply();

                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //  الصلاة  التراويح
    public void TarawehMethod() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("Taraweh_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioTarawehsalahMore.setChecked(true);
            radioTarawehsalahLess.setChecked(false);
            radioTarawehsalahNo.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioTarawehsalahMore.setChecked(false);
            radioTarawehsalahLess.setChecked(true);
            radioTarawehsalahNo.setChecked(false);
        }
        if (jama3a_str_0.equals("1")) {
            radioTarawehsalahMore.setChecked(false);
            radioTarawehsalahLess.setChecked(false);
            radioTarawehsalahNo.setChecked(true);
        }

        radioTarawehsalahMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Taraweh_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("Taraweh_salah" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 10).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioTarawehsalahLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Taraweh_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 10);
                    ShowText.setText(countBeore - 10 + "");
                    editor.putInt("ccounter" + cal, countBeore - 10).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("Taraweh_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        radioTarawehsalahNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Taraweh_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 10);
                    ShowText.setText(countBeore - 10 + "");
                    editor.putInt("ccounter" + cal, countBeore - 10).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("Taraweh_salah" + cal, "1").apply();

                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    //  الصلاة علي النبي
    public void SalahMethod() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("azkar_salah" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioazkarSalahMore.setChecked(true);
            radioazkarSalahLess.setChecked(false);
            radioazkarSalahNo.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioazkarSalahMore.setChecked(false);
            radioazkarSalahLess.setChecked(true);
            radioazkarSalahNo.setChecked(false);
        }
        if (jama3a_str_0.equals("1")) {
            radioazkarSalahMore.setChecked(false);
            radioazkarSalahLess.setChecked(false);
            radioazkarSalahNo.setChecked(true);
        }

        radioazkarSalahMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("azkar_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);

                if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();
                }
                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("azkar_salah" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioazkarSalahLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("azkar_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("azkar_salah" + cal, "2").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 2).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();


            }
        });
        radioazkarSalahNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("azkar_salah" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();

                } else if (jama3a_str_checer.equals("2")) {
                    Progressbar.setProgress(countBeore - 2);
                    ShowText.setText(countBeore - 2 + "");
                    editor.putInt("ccounter" + cal, countBeore - 2).apply();

                }
                if (!jama3a_str_checer.equals("1")) {
                    editor.putString("azkar_salah" + cal, "1").apply();

                } else if (jama3a_str_checer.equals("1")) {
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Sadaka
    public void Sadaka() {
        int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
        String jama3a_str_0 = sharedPref.getString("Sadaka" + cal, "0");
        if (jama3a_str_0.equals("3")) {
            radioSadakaYes.setChecked(true);
            radioSadakaNo.setChecked(false);
        }
        if (jama3a_str_0.equals("2")) {
            radioSadakaYes.setChecked(false);
            radioSadakaNo.setChecked(true);
        }

        radioSadakaYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Sadaka" + cal, "0");

                if (!jama3a_str_checer.equals("3")) {

                    editor.putString("Sadaka" + cal, "3").apply();
                    int count = sharedPref.getInt("ccounter" + cal, 0);
                    editor.putInt("ccounter" + cal, count + 5).apply();
                    int countAfter = sharedPref.getInt("ccounter" + cal, 0);
                    Progressbar.setProgress(countAfter);
                    ShowText.setText(countAfter + "");
                } else if (jama3a_str_checer.equals("3"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();
            }
        });
        radioSadakaNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = hajreCalendar.get(Calendar.DAY_OF_MONTH); // 14
                String jama3a_str_checer = sharedPref.getString("Sadaka" + cal, "0");
                int countBeore = sharedPref.getInt("ccounter" + cal, 0);
                if (jama3a_str_checer.equals("3")) {
                    Progressbar.setProgress(countBeore - 5);
                    ShowText.setText(countBeore - 5 + "");
                    editor.putInt("ccounter" + cal, countBeore - 5).apply();
                }
                if (!jama3a_str_checer.equals("2")) {

                    editor.putString("Sadaka" + cal, "2").apply();

                } else if (jama3a_str_checer.equals("2"))
                    Toast.makeText(TodoMainActivity.this, "تم الاختيار مسبقا !!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void retriveSharedValue() {

        List<todoAlarmService.Empl> set2 = Paper.book().read("setCounter5");
        if (set2 != null) {
            arrPackage.addAll(set2);
        }
    }
}