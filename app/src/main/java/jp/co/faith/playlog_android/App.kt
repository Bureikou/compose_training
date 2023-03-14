package jp.co.faith.playlog_android

import android.app.Application
import android.content.Context

class App : Application(){

    companion object {
        private lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}