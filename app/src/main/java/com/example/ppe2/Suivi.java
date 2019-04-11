package com.example.ppe2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;

public class Suivi extends Fragment {


    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        GraphView graph = (GraphView) this.getActivity().findViewById(R.id.graph);
        GraphView graph2 = (GraphView) this.getActivity().findViewById(R.id.graph2);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5,15)
        });
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 10),
                new DataPoint(1, 50),
                new DataPoint(2, 30),
                new DataPoint(3, 20),
                new DataPoint(4, 60),
                new DataPoint(5,0),
                new DataPoint(6, 30),
                new DataPoint(7, 12),
                new DataPoint(8, 60),
                new DataPoint(9, 41),
                new DataPoint(10, 20),
                new DataPoint(11,22)
        });
        graph.addSeries(series);
        series.setTitle("Moyenne sur la journée");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph.getGridLabelRenderer().setVerticalAxisTitle("T°");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Jour");
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(20);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(10);


        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Vous avez appuyé sur le point : "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });



        graph2.addSeries(series2);
        series2.setTitle("Moyenne sur la journée");
        graph2.getLegendRenderer().setVisible(true);
        graph2.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph2.getGridLabelRenderer().setVerticalAxisTitle("% d'humidité");
        graph2.getGridLabelRenderer().setHorizontalAxisTitle("Jour");
        graph2.getViewport().setScrollable(true); // enables horizontal scrolling
        graph2.getViewport().setScrollableY(true); // enables vertical scrolling
        graph2.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph2.getViewport().setScalableY(true); // enables vertical zooming and scrolling

        graph2.getViewport().setYAxisBoundsManual(true);
        graph2.getViewport().setMinY(0);
        graph2.getViewport().setMaxY(100);

        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(0);
        graph2.getViewport().setMaxX(15);


        series2.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(getActivity(), "Vous avez appuyé sur le point "+dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
   }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_suivi,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }


}
