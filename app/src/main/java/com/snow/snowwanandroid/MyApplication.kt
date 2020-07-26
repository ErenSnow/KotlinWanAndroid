package com.snow.snowwanandroid

import android.app.Application
import android.content.Context

val appContext: Context by lazy { MyApplication.context }

class MyApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}