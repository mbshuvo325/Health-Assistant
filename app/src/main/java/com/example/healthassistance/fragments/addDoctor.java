package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.healthassistance.R;
import com.example.healthassistance.pojos.DoctorPojo;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class addDoctor extends Fragment {
    private TextInputEditText docotrNameTIET,hospitalNameTIET,phoneNumberTIET;
    private Button cameraInputImageBTN,galleryInputImageBTN,saveDocotrBTN,cancelBTN;
    private DoctorPojo docotrpojo;


    public addDoctor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_doctor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        docotrNameTIET = view.findViewById(R.id.doctorNametiet);
        hospitalNameTIET = view.findViewById(R.id.hospitaltiet);
        phoneNumberTIET = view.findViewById(R.id.phoneNumbertiet);
        cameraInputImageBTN = view.findViewById(R.id.imageInputCamera);
        galleryInputImageBTN = view.findViewById(R.id.imageInputGallery);
        saveDocotrBTN = view.findViewById(R.id.saveDoctorbtn);
        cancelBTN = view.findViewById(R.id.cancelbtn);

        cameraInputImageBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use for camera
            }
        });

        galleryInputImageBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use for gallery input
            }
        });

        saveDocotrBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String doctorName = docotrNameTIET.getText().toString();
                String hospitaName = hospitalNameTIET.getText().toString();
                String phoneNumber = phoneNumberTIET.getText().toString();
                if (doctorName.isEmpty()){
                    docotrNameTIET.setError("Must Give a Name..!");
                }else{
                    docotrpojo = new DoctorPojo(null,doctorName,hospitaName,phoneNumber);
                }
            }
        });
    }
}
