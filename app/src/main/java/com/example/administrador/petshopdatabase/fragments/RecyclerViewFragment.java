package com.example.administrador.petshopdatabase.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrador.petshopdatabase.R;
import com.example.administrador.petshopdatabase.adapter.CatalogAdapter;
import com.example.administrador.petshopdatabase.database.DBSettings;
import com.example.administrador.petshopdatabase.database.DataBaseHelper;
import com.example.administrador.petshopdatabase.dataset.PetCatalog;

import java.util.ArrayList;

/**
 * Created by Administrador on 07/07/2016.
 */
public class RecyclerViewFragment  extends Fragment {
    public static int exist = 0;
    ArrayList<PetCatalog> petCatalogs;
    RecyclerView rvCatalogList;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view,container,false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        rvCatalogList = (RecyclerView) view.findViewById(R.id.recPetCatalog);

        //GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        //rvCatalogList.setLayoutManager(glm);

        LinearLayoutManager myLinLayout = new LinearLayoutManager(getActivity());
        myLinLayout.setOrientation(LinearLayoutManager.VERTICAL);

        rvCatalogList.setLayoutManager(myLinLayout);
        startPetCatalogList();
        startAdapter();

        return  view;
    }

    public void startPetCatalogList(){
        petCatalogs = new ArrayList<PetCatalog>();
        /*
        petCatalogs.add( new PetCatalog(R.drawable.benito_little ,"1", "1", "Benito",""));
        petCatalogs.add( new PetCatalog(R.drawable.perro_little,"1", "3", "Baby Dog",""));
        petCatalogs.add( new PetCatalog(R.drawable.atom_ant_little,"1", "4", "Atom Ant",""));
        petCatalogs.add( new PetCatalog(R.drawable.woody_woodpecker_little ,"0", "6", "Woodpecker",""));
        petCatalogs.add( new PetCatalog(R.drawable.osohormiguero_little,"0", "5", "Oso H",""));
        petCatalogs.add( new PetCatalog(R.drawable.demostenes_little,"0", "4", "Demostenes",""));
        petCatalogs.add( new PetCatalog(R.drawable.inspector_little,"0", "4", "Brave Lion",""));
        petCatalogs.add( new PetCatalog(R.drawable.tigre_little,"0", "7", "Sport Tiger",""));
        */
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        //veryfying if databae has records

        petCatalogs =  dataBaseHelper.getAllRecords();

        if (exist <= 0 && petCatalogs.size() <= 0){
            addMultiContacts(dataBaseHelper);
        }
        exist = 1;
        petCatalogs =  dataBaseHelper.getAllRecords();


    }

    public void startAdapter(){
        CatalogAdapter catalogAdapter = new CatalogAdapter(petCatalogs, getContext());
        rvCatalogList.setAdapter(catalogAdapter);
    }

    public void addMultiContacts(DataBaseHelper dataBaseHelper){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Benito");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.benito_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Hormiga");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.atom_ant_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Buho");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.boho_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Demostenes");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.demostenes_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Inspector");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.inspector_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Leon");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.leon_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Hormiguero");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.osohormiguero_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Pupy");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.perro_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Tiger");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.tigre_little);
        dataBaseHelper.addContacts(contentValues);

        contentValues.put(DBSettings.TABLE_CATALOG_PET_NAME, "Woody");
        contentValues.put(DBSettings.TABLE_CATALOG_PET_LIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_DISLIKES, 0);
        contentValues.put(DBSettings.TABLE_CATALOG_PET_PICTURE, R.drawable.woody_woodpecker_little);
        dataBaseHelper.addContacts(contentValues);

    }
}
