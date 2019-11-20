package com.example.esoftwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.esoftwarica.fragments.Fragment_AboutUs;
import com.example.esoftwarica.fragments.Fragment_AddStudent;
import com.example.esoftwarica.fragments.Fragment_Home;
import com.example.esoftwarica.model.ProfileList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Navigation_Bottom extends AppCompatActivity {
    BottomNavigationView bnv;
    public static List<ProfileList> profileLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__bottom);


         bnv = findViewById(R.id.nav_menu);
         bnv.setOnNavigationItemSelectedListener(selected_nav_items);

         getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new Fragment_Home()).commit();
         // loading home fragment as first fragment

        profileLists =new ArrayList<>();

        profileLists.add(new ProfileList("Rupesh Dhakal", "Nayabazar, Kathmandu", "Male", 21, R.drawable.gender_male));
        profileLists.add(new ProfileList("Emma Watson", "London, UK", "Female", 28, R.drawable.gender_female));
        profileLists.add(new ProfileList("Ellen DeGeneres", "La,USA", "Others", 61, R.drawable.gender_other));

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener selected_nav_items = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragSelected = null;

            switch (menuItem.getItemId()) {
                case R.id.nav_home_menu:
                    fragSelected = new Fragment_Home();
                    break;
                case R.id.nav_addStudent_menu:
                    fragSelected = new Fragment_AddStudent();
                    break;
                case R.id.nav_about_menu:
                    fragSelected = new Fragment_AboutUs();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,
                    fragSelected).commit();

            return true;
        }
    };
}

