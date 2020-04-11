package com.example.yukmangan.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    public static final String SP_LOGIN = "spLogin";
    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public PreferenceHelper(Context context){
        sp = context.getSharedPreferences(SP_LOGIN, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    /*public void logoutUser() {
        // Clearing all data from Shared Preferences
        boolean look = false;
        if (this.checkFirstLook()) {
            look = true;
        }
        String iduser = this.getIduser();
        String username = this.getNama();

        spEditor.clear();
        spEditor.commit();
        this.setIduser(iduser);
        this.setNama(username);;

        if (look) {
            this.setFirstlook();
        }
    }*/

}
