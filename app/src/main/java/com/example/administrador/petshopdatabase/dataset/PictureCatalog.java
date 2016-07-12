package com.example.administrador.petshopdatabase.dataset;

/**
 * Created by Administrador on 07/07/2016.
 */
public class PictureCatalog {
    private String strPetName;
    private String strPetLikes;
    private int intPetPicture;
    private int intPicturePetID;

   public PictureCatalog(int intPetPicture, String strPetLikes, String strPetName, int intPicturePetID) {
        this.intPetPicture = intPetPicture;
        this.intPicturePetID = intPicturePetID;
        this.strPetLikes = strPetLikes;
        this.strPetName = strPetName;
    }

    public PictureCatalog(int intPetPicture, String strPetLikes, String strPetName) {
        this.intPetPicture = intPetPicture;
        this.strPetLikes = strPetLikes;
        this.strPetName = strPetName;
        this.intPicturePetID = 0;
    }

    public int getIntPicturePetID() {
        return intPicturePetID;
    }

    public void setIntPicturePetID(int intPicturePetID) {
        this.intPicturePetID = intPicturePetID;
    }

    public int getIntPetPicture() {
        return intPetPicture;
    }

    public void setIntPetPicture(int intPetPicture) {
        this.intPetPicture = intPetPicture;
    }

    public String getStrPetLikes() {
        return strPetLikes;
    }

    public void setStrPetLikes(String strPetLikes) {
        this.strPetLikes = strPetLikes;
    }

    public String getStrPetName() {
        return strPetName;
    }

    public void setStrPetName(String strPetName) {
        this.strPetName = strPetName;
    }
}
