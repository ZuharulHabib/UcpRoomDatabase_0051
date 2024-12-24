package com.example.ucp2_roomdatabase_051.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2_roomdatabase_051.ui.view.DetailJadwalView
import com.example.ucp2_roomdatabase_051.ui.view.DokterView
import com.example.ucp2_roomdatabase_051.ui.view.HomeView
import com.example.ucp2_roomdatabase_051.ui.view.InsertDokterView
import com.example.ucp2_roomdatabase_051.ui.view.InsertJadwalView
import com.example.ucp2_roomdatabase_051.ui.view.JadwalView
import com.example.ucp2_roomdatabase_051.ui.view.UpdateJadwalView
import androidx.compose.ui.Modifier

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiHome.route) {
        composable(route = DestinasiHome.route) {
            HomeView(
                onNavigateDokter = {
                    navController.navigate(DestinasiDokter.route)
                },
                onNavigateJaddwal = {
                    navController.navigate(DestinasiJadwal.route)
                },
                modifier = modifier
            )
        }

        composable(route = DestinasiDokter.route) {
            DokterView(
                onBack = {
                    navController.popBackStack()
                },
                onAddDokter = {
                    navController.navigate(DestinasiInsertDr.route)
                },
                onNavigateDokter = {
                    navController.navigate(DestinasiDokter.route)
                },
                modifier = modifier
            )
        }

        composable(route = DestinasiJadwal.route) {
            JadwalView(
                onBack = {
                    navController.popBackStack()
                },
                onAddJadwal = {
                    navController.navigate(DestinasiInsertJd.route)
                },
                onDetail = { idAntrian ->
                    navController.navigate("${DestinasiDetail.route}/$idAntrian")
                },
                onNavigateJadwal = {
                    navController.navigate(DestinasiJadwal.route)
                },
                onClick = { },
                modifier = modifier
            )
        }

        composable(route = DestinasiInsertDr.route) {
            InsertDokterView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigateDokter = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }

        composable(route = DestinasiInsertJd.route) {
            InsertJadwalView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigateJadwal = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }

        composable(
            route = DestinasiDetail.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.idAntrian) {
                    type = NavType.StringType
                }
            )
        ) {
            val idAntrian = it.arguments?.getString(DestinasiDetail.idAntrian)
            idAntrian?.let { idAntrianValue ->
                DetailJadwalView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = { kode ->
                        navController.navigate("${DestinasiUpdate.route}/$kode")
                    },
                    onDeleteClick = {
                        navController.popBackStack()
                    },
                    idAntrian = idAntrianValue,
                    modifier = modifier
                )
            }
        }

        composable(
            route = DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.idAntrian) {
                    type = NavType.StringType
                }
            )
        ) {
            val idAntrian = it.arguments?.getString(DestinasiUpdate.idAntrian)
            idAntrian?.let { kode ->
                UpdateJadwalView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onNavigateJadwal = {
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            }
        }
    }
}