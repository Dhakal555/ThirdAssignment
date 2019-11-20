package com.example.esoftwarica.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.esoftwarica.Navigation_Bottom;
import com.example.esoftwarica.R;
import com.example.esoftwarica.adapter.Adapter_ProfileList;


public class Fragment_Home extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_fragment__home, container, false);

        recyclerView = view.findViewById(R.id.recycleDetailList);

        Adapter_ProfileList adapter_profileList = new Adapter_ProfileList(getContext(), Navigation_Bottom.profileLists);
        recyclerView.setAdapter(adapter_profileList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
