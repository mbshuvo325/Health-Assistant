package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.healthassistance.R;
import com.example.healthassistance.viewmodels.LoginViewmodel;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoard extends Fragment {

    private CardView doctorCV,prescriptionCV,hospitalCV,ambulanceCV,pharmacyCV,billCV;

    private Button logoutBtn;
    private LoginViewmodel loginViewmodel;


    public DashBoard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginViewmodel = ViewModelProviders.of(this).get(LoginViewmodel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        doctorCV = view.findViewById(R.id.doctorcv);
        prescriptionCV = view.findViewById(R.id.prescriptioncv);
        hospitalCV = view.findViewById(R.id.hospitalcv);
        ambulanceCV = view.findViewById(R.id.ambulancecv);
        pharmacyCV = view.findViewById(R.id.pharmacycv);
        billCV = view.findViewById(R.id.billcv);
        logoutBtn = view.findViewById(R.id.logoutbtn);

        doctorCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.docotr);
            }
        });

        prescriptionCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.prescription);

            }
        });

        hospitalCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ambulanceCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pharmacyCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        billCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               loginViewmodel.LogOutUser();
               Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.login);
            }
        });

    }
}
