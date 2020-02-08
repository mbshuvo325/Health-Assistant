package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.healthassistance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Docotr extends Fragment {
    private RecyclerView doctorRV;
    private FloatingActionButton addDoctorFABTN;
    private TextView addDoctorTV;


    public Docotr() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_docotr, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doctorRV = view.findViewById(R.id.doctorRv);
        addDoctorFABTN = view.findViewById(R.id.addDoctorfabtn);
        addDoctorTV = view.findViewById(R.id.addDoctortv);

        addDoctorTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_graph).navigate(R.id.addDoctor);
            }
        });

        addDoctorFABTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_graph).navigate(R.id.addDoctor);
            }
        });
    }
}
