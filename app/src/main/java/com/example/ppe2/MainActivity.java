package com.example.ppe2;

import android.annotation.SuppressLint;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ppe2.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    ImageButton LeftButton,RightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.left_nav_view);
        NavigationView navigationView2 = findViewById(R.id.right_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView2.setNavigationItemSelectedListener(this);

        LeftButton=(ImageButton) findViewById(R.id.imgLeft);
        RightButton =(ImageButton) findViewById(R.id.imgRight);
        LeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        RightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.END);
            }
        });

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Calendrier()).commit();
            navigationView.setCheckedItem(R.id.nav_calendrier);
        }

    }



    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else if(drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_calendrier:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Calendrier()).commit();
                break;
            case R.id.nav_potager:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Mon_potager()).commit();
                break;
            case R.id.nav_suivi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Suivi()).commit();
                break;
            case R.id.nav_forum:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Forum()).commit();
                break;
            case R.id.nav_fiches:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fiches()).commit();
                break;
            case R.id.nav_hardware:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Hardware()).commit();
                break;
            case R.id.nav_notice:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Notice()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}