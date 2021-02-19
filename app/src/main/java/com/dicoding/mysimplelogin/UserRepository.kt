package com.dicoding.mysimplelogin

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton // jika singletone ini di hapus maka akan instance yang di buak akan berbeda
class UserRepository @Inject constructor(private val sesi: SessionManager) {

    fun loginUser(username: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sesi.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun logoutUser() = sesi.logout()

    fun checkInstance() = Log.d("Singleton", "checkInstance: $this")
}