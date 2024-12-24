package com.example.ucp2_roomdatabase_051.Data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appname.entity.Dokter
import com.example.ucp2_roomdatabase_051.Data.dao.DokterDao
import com.example.ucp2_roomdatabase_051.Data.dao.JadwalDao
import com.example.ucp2_roomdatabase_051.entity.Jadwal
import kotlin.concurrent.Volatile

@Database(entities = [Dokter::class, Jadwal::class], version = 1, exportSchema = false)
abstract class HospitalDatabase: RoomDatabase() {
    abstract fun dokterDao(): DokterDao
    abstract fun jadwalDao(): JadwalDao

    companion object {
        @Volatile
        private var Instance: HospitalDatabase? = null

        fun getDatabase(context: Context): HospitalDatabase {
            return(Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    HospitalDatabase::class.java,
                    name ="HospitalDatabase"
                )
                    .build().also { Instance = it }
            })
        }
    }
}