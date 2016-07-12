package com.example.administrador.petshopdatabase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrador.petshopdatabase.dataset.PictureCatalog;
import com.example.administrador.petshopdatabase.R;

import java.util.ArrayList;

/**
 * Created by Administrador on 07/07/2016.
 */
public class PictureAdapter  extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder>{
    ArrayList<PictureCatalog> pictureCatalogs;
    Context context;

    public PictureAdapter(ArrayList<PictureCatalog> pictureCatalogs){
        this.pictureCatalogs = pictureCatalogs;
    }
    public PictureAdapter(ArrayList<PictureCatalog> pictureCatalogs, Context context){
        this.pictureCatalogs = pictureCatalogs;
        this.context = context;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewpetpicture, parent, false);
        return new PictureViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder pictureViewHolder, int position) {
        PictureCatalog pictureCatalog = pictureCatalogs.get(position);
        pictureViewHolder.imgCVPetPicture.setImageResource(pictureCatalog.getIntPetPicture());
        pictureViewHolder.txtCVPetLikes.setText(pictureCatalog.getStrPetLikes());
        //pictureViewHolder.txtPetName.setText(pictureCatalog.getStrPetName());

    }

    @Override
    public int getItemCount() {
        return pictureCatalogs.size();
    }


    public static class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCVPetPicture;
        private TextView txtCVPetLikes;
        private TextView txtPetName;

        public PictureViewHolder(View itemView) {
            super(itemView);

            imgCVPetPicture = (ImageView) itemView.findViewById(R.id.imgPetPicture);
            txtCVPetLikes = (TextView)itemView.findViewById(R.id.txtPetLikes);
            txtPetName = (TextView)itemView.findViewById(R.id.txtPetName);
        }
    }
}
