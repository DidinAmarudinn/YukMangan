package com.example.yukmangan.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {


    private final String INTRO = "intro";
    private final String NAME = "name";
    private final String ID = "id";
    private final String ALAMAT="alamat";
    private final String EMAIL="email";
    private final String JK="jk";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("shared",
                Context.MODE_PRIVATE);
        this.context = context;
    }
    public void putIsLogin(boolean loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(INTRO, loginorout);
        edit.commit();
    }
    public boolean getIsLogin() {
        return app_prefs.getBoolean(INTRO, false);
    }

    public void putName(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NAME, loginorout);
        edit.commit();
    }
    public String getName() {
        return app_prefs.getString(NAME, "");
    }

    public void putId(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(ID, loginorout);
        edit.commit();
    }
    public String getID() {
        return app_prefs.getString(ID, "");

    } public void putAlamat(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(ALAMAT, loginorout);
        edit.commit();
    }
    public String getAlamat() {
        return app_prefs.getString(ALAMAT, "");
    }
    public void putEmail(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(EMAIL, loginorout);
        edit.commit();
    }
    public String getEMAIL() {
        return app_prefs.getString(EMAIL, "");
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
    public void putJk(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(JK, loginorout);
        edit.commit();
    }
    public String getJk() {
        return app_prefs.getString(JK, "");
    }
}
