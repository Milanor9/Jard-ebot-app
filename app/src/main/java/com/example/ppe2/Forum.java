package com.example.ppe2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Forum extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_forum,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        Button btn=(Button) v.findViewById(R.id.Facebook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFacebookPage("1280509758711078");
                //gotoFacebookPage("noiseece/");
            }
        });
        return v;
    }
    private void gotoFacebookPage(String id){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+id));
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("fb://www.facebook.com/"+id));
            startActivity(intent);
        }
    }
}
