package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.healthassistance.R;
import com.example.healthassistance.pojos.DoctorPojo;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class addDoctor extends Fragment {
    private TextInputEditText docotrNameTIET,hospitalNameTIET,phoneNumberTIET;
    private Button saveDocotrBTN,cancelBTN;
    private ImageView cameraInputImage,galleryInputImage;
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
        cameraInputImage = view.findViewById(R.id.docotrCameraInput);
        galleryInputImage = view.findViewById(R.id.docotrGalleryInput);
        saveDocotrBTN = view.findViewById(R.id.saveDoctorbtn);
        cancelBTN = view.findViewById(R.id.cancelbtn);

        cameraInputImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //use for camera
            }
        });

        galleryInputImage.setOnClickListener(new View.OnClickListener() {
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

        cancelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.docotr);
            }
        });
    }
}
