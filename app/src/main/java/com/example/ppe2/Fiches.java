package com.example.ppe2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fiches extends Fragment {
    private Button button_tomate;
    private Button button_carotte;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fiches,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button_tomate = (Button) this.getActivity().findViewById(R.id.btn_tomate);
        button_tomate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OuvrirTomate();
            }
        });
        button_carotte = (Button) this.getActivity().findViewById(R.id.btn_carotte);
        button_carotte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OuvrirCarotte();
            }
        });
    }
    public void OuvrirTomate(){
        Intent intent = new Intent(this.getContext(),ActivityTomate.class);
        startActivity(intent);
    }
    public void OuvrirCarotte(){
        Intent intent = new Intent(this.getContext(),ActivityCarotte.class);
        startActivity(intent);
    }
}
