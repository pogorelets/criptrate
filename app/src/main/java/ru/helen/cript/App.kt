package ru.helen.cript

import android.app.Application
import ru.helen.cript.di.AppComponent
import ru.helen.cript.di.AppModule
import ru.helen.cript.di.DaggerAppComponent

/**
 * Created by lenap on 03.03.2018.
 */
class App : Application() {
    lateinit var appComponent: AppComponent
    private lateinit var instance: App

    fun getInstance(): App? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext)).build()
    }

    companion object {
        fun getAppComponent(app: App) : AppComponent = app.appComponent
    }
}