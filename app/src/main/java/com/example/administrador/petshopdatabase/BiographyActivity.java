package com.example.administrador.petshopdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.administrador.petshopdatabase.R;

public class BiographyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myToolbar);
        myActionBar.setTitle("Biography Info");
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
