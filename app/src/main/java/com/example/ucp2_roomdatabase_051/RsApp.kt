package com.example.ucp2_roomdatabase_051

import android.app.Application
import com.example.ucp2_roomdatabase_051.dependeciesinjection.ContainerApp


class RsApp : Application() {
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}