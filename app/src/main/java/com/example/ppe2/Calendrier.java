package com.example.ppe2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calendrier extends Fragment {
    CalendarView calendar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_calendrier,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //this.getActivity().setContentView(R.layout.fragment_calendrier);
        calendar=(CalendarView) this.getActivity().findViewById(R.id.calendrier);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if(dayOfMonth == 12 && month+1 == 4 ){
                    Toast.makeText(view.getContext(),"Soutenance",Toast.LENGTH_LONG).show();
                }
                else if(dayOfMonth == 20 && month+1 == 4 ){
                    Toast.makeText(view.getContext(),"Récolte des tomates",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(view.getContext(),"Date sélectionnée "+dayOfMonth+"/"+(month+1)+"/"+year,Toast.LENGTH_LONG).show();
            }
        });
    }
}
