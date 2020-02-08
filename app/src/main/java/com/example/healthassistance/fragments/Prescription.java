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
public class Prescription extends Fragment {
    private RecyclerView prescriptionRV;
    private TextView addPrescriptionTV;
    private FloatingActionButton addPrescriptionFABTN;


    public Prescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prescription, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prescriptionRV = view.findViewById(R.id.prescriptionRv);
        addPrescriptionTV = view.findViewById(R.id.addPrescriptiontv);
        addPrescriptionFABTN = view.findViewById(R.id.addPrescriptionfabtn);

        addPrescriptionTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.addPrescription);
            }
        });

        addPrescriptionFABTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.addPrescription);
            }
        });

    }
}
