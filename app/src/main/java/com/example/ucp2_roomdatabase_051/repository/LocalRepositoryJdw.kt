package com.example.ucp2_roomdatabase_051.repository

import com.example.ucp2_roomdatabase_051.Data.dao.JadwalDao
import com.example.ucp2_roomdatabase_051.entity.Jadwal
import kotlinx.coroutines.flow.Flow

class LocalRepositoryJdw(
    private val jadwalDao: JadwalDao
) : RepositoryJdw {

    override suspend fun insertJdw(jadwal: Jadwal) {
        jadwalDao.insertJd(jadwal)
    }

    override fun getAllJdw(): Flow<List<Jadwal>> {
        return jadwalDao.getAllJd()
    }

    override fun getJdw(idAntrian: String): Flow<Jadwal> {
        return jadwalDao.getJd(idAntrian)
    }

    override suspend fun deleteJdw(jadwal: Jadwal) {
        jadwalDao.deleteJd(jadwal)
    }

    override suspend fun updateJdw(jadwal: Jadwal) {
        jadwalDao.updateJd(jadwal)
    }
}