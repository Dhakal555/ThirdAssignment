package com.example.esoftwarica.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esoftwarica.Navigation_Bottom;
import com.example.esoftwarica.model.ProfileList;
import com.example.esoftwarica.R;

import java.util.List;


public class Fragment_AddStudent extends Fragment {
    TextView name, age, address;
    RadioButton rdBtn;
    RadioGroup rdGrp;
    Button btnSave;

    List <ProfileList> profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_fragment__add_student, container, false);

        name = view.findViewById(R.id.tvFname);
        age = view.findViewById(R.id.tvAge);
        address = view.findViewById(R.id.tvAddress);
        rdGrp = view.findViewById(R.id.rdoGrp);
        btnSave = view.findViewById(R.id.btnSaveInfo);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int defaultGender = rdGrp.getCheckedRadioButtonId();
                rdBtn = view.findViewById(defaultGender);
                if(validate()){
                    profile = Navigation_Bottom.profileLists;
                    int defineImage = R.drawable.gender_male;
                    if(rdBtn.getText().toString().equals("Female")){
                        defineImage = R.drawable.gender_female;
                    }
                    if(rdBtn.getText().toString().equals("Others")){
                        defineImage = R.drawable.gender_other;
                    }

                    ProfileList pl = new ProfileList(
                            name.getText().toString(),
                            address.getText().toString(),
                            rdBtn.getText().toString(),
                            Integer.parseInt(age.getText().toString()),
                            defineImage);
                    profile.add(pl);
                    Toast.makeText(getContext(),"Student Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public boolean validate(){
        if (name.getText().toString().trim().isEmpty()){
            name.setError("Please Enter Full Name");
            return false;
        }
        if (age.getText().toString().trim().isEmpty()){
            age.setError("Age is required");
            return false;
        }
        if (address.getText().toString().trim().isEmpty()){
            address.setError("address is required");
            return false;
        }
        return true;
    }

}
