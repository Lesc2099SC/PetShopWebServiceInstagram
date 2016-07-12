package com.example.administrador.petshopdatabase;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.administrador.petshopdatabase.R;
import com.example.administrador.petshopdatabase.adapter.PictureAdapter;
import com.example.administrador.petshopdatabase.database.DataBaseHelper;
import com.example.administrador.petshopdatabase.dataset.PictureCatalog;

import java.util.ArrayList;

public class TopFiveActivity extends AppCompatActivity {

    ArrayList<PictureCatalog> pictureCatalogs;
    RecyclerView rvTopFiveView;
    Context context;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myToolbar);
        myActionBar.setTitle("Top Five Pet");
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rvTopFiveView = (RecyclerView) findViewById(R.id.recTopFive);

        LinearLayoutManager myLinLayout = new LinearLayoutManager(this);
        myLinLayout.setOrientation(LinearLayoutManager.VERTICAL);
        rvTopFiveView.setLayoutManager(myLinLayout);
        getTopFive();
        startAdapter();

    }

    public void getTopFive(){
        pictureCatalogs = new ArrayList<PictureCatalog>();
        DataBaseHelper dataBaseHelper = new DataBaseHelper(TopFiveActivity.this);
        pictureCatalogs = dataBaseHelper.getTopFive();

    }

    public void startAdapter(){
        PictureAdapter pictureAdapter = new PictureAdapter(pictureCatalogs);
        rvTopFiveView.setAdapter(pictureAdapter);
    }
}
