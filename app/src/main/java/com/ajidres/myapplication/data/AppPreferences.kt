package com.ajidres.myapplication.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


class AppPreferences(private val preferences: SharedPreferences) {


    private val PREF_TOKEN = "token"
    private val PREF_REFRESH = "refresh"


    companion object {

        private val PREFS_FILE_NAME = "secure_prefs"
        fun getSharedPreferences(context: Context): SharedPreferences {
            val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
            return EncryptedSharedPreferences.create(
                context,
                PREFS_FILE_NAME,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }
    }

    var token
        get() = preferences.getString(PREF_TOKEN, "")
        set(value) {
            preferences.edit().putString(PREF_TOKEN, value).apply()
        }

    var refresh
        get() = preferences.getString(PREF_REFRESH, "")
        set(value) {
            preferences.edit().putString(PREF_REFRESH, value).apply()
        }

}