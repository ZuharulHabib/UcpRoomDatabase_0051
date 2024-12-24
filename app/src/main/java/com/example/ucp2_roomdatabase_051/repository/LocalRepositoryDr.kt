package com.example.ucp2_roomdatabase_051.repository

import com.example.appname.entity.Dokter
import com.example.ucp2_roomdatabase_051.Data.dao.DokterDao
import kotlinx.coroutines.flow.Flow

class LocalRepositoryDr(
    private val dokterDao: DokterDao
) : RepositoryDr {

    override suspend fun insertDr(dokter: Dokter) {
        dokterDao.insertDokter(dokter)
    }

    override fun getAllDr(): Flow<List<Dokter>> {
        return dokterDao.getAllDokter()
    }

    override fun getDr(idDr: String): Flow<Dokter> {
        return dokterDao.getDokter(idDr)
    }
}