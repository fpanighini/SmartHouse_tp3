package com.example.smarthouse_tp3

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthouse_tp3.advanced_devices.DeviceConfigScreen
import com.example.smarthouse_tp3.ui.NavigationViewModel

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = stringResource(id = R.string.device_screen),
    navigationViewModel: NavigationViewModel = viewModel()
) {
    val navigationUiState by navigationViewModel.uiState.collectAsState()
    val deviceScreen = stringResource(id = R.string.device_screen)
    val placesScreen = stringResource(id = R.string.places_screen)
    val routinesScreen = stringResource(id = R.string.routines_screen)
    val favouritesScreen = stringResource(id = R.string.favorites_screen)

    /*
    val configOvenScreen = stringResource(id = R.string.config_oven_screen)
    val configFaucetScreen = stringResource(id = R.string.config_faucet_screen)
    val configACScreen = stringResource(id = R.string.config_ac_screen)
    val configCurtainScreen = stringResource(id = R.string.config_curtain_screen)
    val configLightScreen = stringResource(id = R.string.config_light_screen)
    val configVacuumScreen = stringResource(id = R.string.config_light_screen)
     */

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        val bottomPadding = Modifier.padding(0.dp, 0.dp, 0.dp, 56.dp)


        //MAIN SCREENS
        composable(routinesScreen) {
            RoutinesScreen()
        }

        composable(deviceScreen) {
            DeviceScreen(
                navigationViewModel = navigationViewModel,
                modifier = bottomPadding
            ) { navController.navigate("Configuration Screen") }
        }

        composable(favouritesScreen) {
            FavoritesScreen(
                modifier = bottomPadding
            ) { deviceID ->
                navController.navigate("Configuration Screen/$deviceID")
            }
        }

        composable(placesScreen) {
            PlacesScreen(
                navigationViewModel = navigationViewModel,
                modifier = bottomPadding
            ) { navController.navigate("Configuration Screen") }
        }


        //SCREEEN DE LOS DISPOSITIVOS
        composable("Configuration Screen") {
            DeviceConfigScreen(navigationUiState.selectedDevice)
        }
    }
}