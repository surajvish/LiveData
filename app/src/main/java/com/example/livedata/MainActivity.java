package com.example.livedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LiveDataObject liveDataObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtName = findViewById(R.id.edt_username);
        final EditText edtAge = findViewById(R.id.edt_age);

        final TextView txtUserName = findViewById(R.id.username);
        final TextView txtAge = findViewById(R.id.age);


        liveDataObject = ViewModelProviders.of(this).get(LiveDataObject.class);
        final Observer<UserDetails> userDetailsObserver = new Observer<UserDetails>() {

            @Override
            public void onChanged(UserDetails userDetails) {
                txtUserName.setText(userDetails.getName());
                txtAge.setText("" + userDetails.getAge());
            }
        };

        findViewById(R.id.clickMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserDetails userDetails = new UserDetails(edtName.getText().toString(), Integer.parseInt(edtAge.getText().toString()));
                liveDataObject.getUserDetailsMutableLiveData().setValue(userDetails);
            }
        });

        liveDataObject.getUserDetailsMutableLiveData().observe(this, userDetailsObserver);
    }
}
