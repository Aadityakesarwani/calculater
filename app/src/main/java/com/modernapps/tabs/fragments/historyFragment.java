package com.modernapps.tabs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.modernapps.tabs.R;
import com.modernapps.tabs.databinding.FragmentHistoryBinding;

public class historyFragment extends Fragment {

    public historyFragment(){}
    FragmentHistoryBinding binding;

ImageButton backHome;
   TextView historyContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentHistoryBinding.inflate(inflater, container, false);

        historyContainer = binding.historyContainer;
        backHome=binding.backHome;


        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return binding.getRoot();
    }

}