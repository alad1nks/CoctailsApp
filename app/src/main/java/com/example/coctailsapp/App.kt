package com.example.coctailsapp

import android.app.Application
import com.example.coctailsapp.di.AppComponent
import com.example.coctailsapp.di.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}