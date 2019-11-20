package com.example.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvUname, tvPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //hiding the title bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        tvUname = findViewById(R.id.etuserName);
        tvPassword = findViewById(R.id.etpwd);

        btnLogin = findViewById(R.id.login);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Validate()) {
                    String username = tvUname.getText().toString();
                    String password = tvPassword.getText().toString();

                    if (username.equals("softwarica") && password.equals("coventry")) {
                        Intent openDetail = new Intent(MainActivity.this, Navigation_Bottom.class);
                        startActivity(openDetail);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid user name or password", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
    }

    public boolean Validate(){
        if(tvUname.getText().toString().trim().isEmpty() || tvPassword.getText().toString().trim().isEmpty()){
            tvUname.setError("Empty Fields", getDrawable(R.drawable.ic_error_black_24dp));
            tvPassword.setError("Empty Fields", getDrawable(R.drawable.ic_error_black_24dp));
            return false;
        }
        return true;
    }
}
