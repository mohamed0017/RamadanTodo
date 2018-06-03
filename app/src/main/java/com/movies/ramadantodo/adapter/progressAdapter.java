package com.movies.ramadantodo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.movies.ramadantodo.R;
import com.movies.ramadantodo.services.todoAlarmService;

import java.util.ArrayList;

/**
 * Created by user on 5/3/2018.
 */

public class progressAdapter extends RecyclerView.Adapter<progressAdapter.holder> {

    private ArrayList<todoAlarmService.Empl> arrayList = new ArrayList<>();
    private Context context;

    public progressAdapter(Context context, ArrayList<todoAlarmService.Empl> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override

    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_progress_single_row, parent, false);
        return new holder(itemView);
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {

        todoAlarmService.Empl dataArray = arrayList.get(position);
        holder.textView.setText(dataArray.getName());
        try {
            holder.progressBar.setProgress(Integer.parseInt(dataArray.getName()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (dataArray.getNumber() == 1)
            holder.textView2.setText("اليوم الاول ");
        else if (dataArray.getNumber() == 2)
            holder.textView2.setText("اليوم الثاني ");
        else if (dataArray.getNumber() == 3)
            holder.textView2.setText("اليوم الثالث ");
        else if (dataArray.getNumber() == 4)
            holder.textView2.setText("اليوم الرابع ");
        else if (dataArray.getNumber() == 5)
            holder.textView2.setText("اليوم الخامس ");
        else if (dataArray.getNumber() == 6)
            holder.textView2.setText("اليوم السادس ");
        else if (dataArray.getNumber() == 7)
            holder.textView2.setText("اليوم السابع ");
        else if (dataArray.getNumber() == 8)
            holder.textView2.setText("اليوم الثامن ");
        else if (dataArray.getNumber() == 9)
            holder.textView2.setText("اليوم التاسع ");
        else if (dataArray.getNumber() == 10)
            holder.textView2.setText("اليوم العاشر ");
        else if (dataArray.getNumber() == 11)
            holder.textView2.setText("اليوم الحادي عشر ");
        else if (dataArray.getNumber() == 12)
            holder.textView2.setText("اليوم الثاني عشر ");
        else if (dataArray.getNumber() == 13)
            holder.textView2.setText("اليوم الثالث عشر ");
        else if (dataArray.getNumber() == 14)
            holder.textView2.setText("اليوم الرابع عشر ");
        else if (dataArray.getNumber() == 15)
            holder.textView2.setText("اليوم الخامس عشر ");
        else if (dataArray.getNumber() == 16)
            holder.textView2.setText("اليوم السادس عشر");
        else if (dataArray.getNumber() == 17)
            holder.textView2.setText("اليوم السابع عشر");
        else if (dataArray.getNumber() == 18)
            holder.textView2.setText("اليوم الثامن عشر ");
        else if (dataArray.getNumber() == 19)
            holder.textView2.setText("اليوم التاسع عشر ");
        else if (dataArray.getNumber() == 20)
            holder.textView2.setText("اليوم العشرين ");
        else if (dataArray.getNumber() == 21)
            holder.textView2.setText("اليوم الحادي و العشرون ");
        else if (dataArray.getNumber() == 22)
            holder.textView2.setText("اليوم الثاني و العشرون  ");
        else if (dataArray.getNumber() == 23)
            holder.textView2.setText("اليوم الثالث و العشرون ");
        else if (dataArray.getNumber() == 24)
            holder.textView2.setText("اليوم الرابع و العشرون ");
        else if (dataArray.getNumber() == 25)
            holder.textView2.setText("اليوم الخامس و العشرون  ");
        else if (dataArray.getNumber() == 26)
            holder.textView2.setText("اليوم السادس والعشرون  ");
        else if (dataArray.getNumber() == 27)
            holder.textView2.setText("اليوم السابع و العشرون  ");
        else if (dataArray.getNumber() == 28)
            holder.textView2.setText("اليوم الثامن والعشرون  ");
        else if (dataArray.getNumber() == 29)
            holder.textView2.setText("اليوم التاسع و العشرون  ");
        else if (dataArray.getNumber() == 30)
            holder.textView2.setText("اليوم الثلاثون  ");
        else if (dataArray.getNumber() == 31)
            holder.textView2.setText("اليوم الحادي والثلاثون ");
        else
            holder.textView2.setText("اليوم  ");

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView textView, textView2;
        ProgressBar progressBar;

        public holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewCount);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar2);
            textView2 = (TextView) itemView.findViewById(R.id.textViewDay);
        }
    }
}
