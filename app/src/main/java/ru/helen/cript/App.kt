package ru.helen.cript

import android.app.Application


/**
 * Created by lenap on 03.03.2018.
 */
class App : Application() {

    private lateinit var instance: App

    fun getInstance(): App? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()

    }

}