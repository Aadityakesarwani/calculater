package com.modernapps.tabs;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.modernapps.tabs.fragments.BMI;
import com.modernapps.tabs.fragments.Calc;
import com.modernapps.tabs.fragments.Finance;
import com.modernapps.tabs.ui.main.SectionsPagerAdapter;
import com.modernapps.tabs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

Fragment fragment;
FragmentManager fragmentManager;

Calc calc;
BMI bmi;
Finance finance;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        tabs.getTabAt(0).setIcon(R.drawable.calc);
        tabs.getTabAt(1).setIcon(R.drawable.dashboard);
        tabs.getTabAt(2).setIcon(R.drawable.currency);



        calc = new Calc();
        bmi = new BMI();
        finance=new Finance();




    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item)
//    {
//        switch(item.getItemId()){
//            case R.id.clean:
//                setContentView();
//                break;
//        }
//    }

}







//        FloatingActionButton fab = binding.fab;

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
/*
        Button b1 = findViewById(R.id.clean);

        MediaPlayer mediaPlayer =MediaPlayer.create(this,R.raw.buttonclick1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });*/



