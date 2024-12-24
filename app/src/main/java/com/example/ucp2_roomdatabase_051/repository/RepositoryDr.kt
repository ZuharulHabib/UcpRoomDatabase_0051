package com.example.ucp2_roomdatabase_051.repository

import com.example.appname.entity.Dokter
import kotlinx.coroutines.flow.Flow

interface RepositoryDr {

    suspend fun insertDr(dokter: Dokter)

    // getAllDokter
    fun getAllDr(): Flow<List<Dokter>>

    // getDokter
    fun getDr(idDr: String): Flow<Dokter>
}