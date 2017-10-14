package com.arbaini.drfauthretrofit.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xplore on 10/14/17.
 */

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "detailiduser";
    private static final String ID_USERNAME = "username";
    private static final String ID_PK = "primarykey";
    private static final String ID_TOKEN = "token";
    private static final String ID_EMAIL = "email";
    private static final String LOGIN_STAT = "loginstatus";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIdUsername(String idUsername) {
        editor.putString(ID_USERNAME, idUsername);
        editor.commit();
    }

    public String getIdUsername() {
        return pref.getString(ID_USERNAME, "Null");
    }

    public void setIdPk(String idPk) {
        editor.putString(ID_PK, idPk);
        editor.commit();
    }

    public String getIdPk() {
        return pref.getString(ID_PK, "Null");
    }

    public void setIdToken(String idToken) {
        editor.putString(ID_TOKEN, idToken);
        editor.commit();
    }

    public String getIdToken() {
        return pref.getString(ID_TOKEN, "Null");
    }

    public void setIdEmail(String idEmail) {
        editor.putString(ID_EMAIL, idEmail);
        editor.commit();
    }

    public String getIdEmail() {
        return pref.getString(ID_EMAIL, "Null");
    }

    public void setLoginStat(boolean loginstat) {
        editor.putBoolean(LOGIN_STAT, loginstat);
        editor.commit();
    }

    public boolean getLoginStat() {
        return pref.getBoolean(LOGIN_STAT, false);
    }

}