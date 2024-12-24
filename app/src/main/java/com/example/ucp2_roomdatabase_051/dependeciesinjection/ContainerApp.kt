package com.example.ucp2_roomdatabase_051.dependeciesinjection

import android.content.Context
import com.example.ucp2_roomdatabase_051.Data.database.HospitalDatabase
import com.example.ucp2_roomdatabase_051.repository.LocalRepositoryDr
import com.example.ucp2_roomdatabase_051.repository.LocalRepositoryJdw
import com.example.ucp2_roomdatabase_051.repository.RepositoryDr
import com.example.ucp2_roomdatabase_051.repository.RepositoryJdw


interface InterfaceContainerApp {
    val repositoryDr: RepositoryDr
    val repositoryJdw: RepositoryJdw
}

class ContainerApp(private val context: Context): InterfaceContainerApp {
    override val repositoryDr: RepositoryDr by lazy {
        LocalRepositoryDr(HospitalDatabase.getDatabase(context).dokterDao())
    }
    override val repositoryJdw: RepositoryJdw by lazy {
        LocalRepositoryJdw(HospitalDatabase.getDatabase(context).jadwalDao())
    }
}