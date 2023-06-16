package com.example.smarthouse_tp3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthouse_tp3.advanced_devices.AirConditionerConfigScreen
import com.example.smarthouse_tp3.advanced_devices.DeviceConfigScreen
import com.example.smarthouse_tp3.advanced_devices.LightConfigScreen
import com.example.smarthouse_tp3.advanced_devices.OvenConfigScreen

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = stringResource(id = R.string.device_screen)
){
    val deviceScreen = stringResource(id = R.string.device_screen)
    val placesScreen = stringResource(id = R.string.places_screen)
    val routinesScreen = stringResource(id = R.string.routines_screen)
    val favouritesScreen = stringResource(id = R.string.favourites_screen)

    val configOvenScreen = stringResource(id = R.string.config_oven_screen)
    val configFaucetScreen = stringResource(id = R.string.config_faucet_screen)
    val configACScreen = stringResource(id = R.string.config_ac_screen)
    val configCurtainScreen = stringResource(id = R.string.config_curtain_screen)
    val configLightScreen = stringResource(id = R.string.config_light_screen)
    val configVacuumScreen = stringResource(id = R.string.config_light_screen)




    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        //MAIN SCREENS
        composable(routinesScreen){
            RoutinesScreen(
                onNavigateToDevicesScreen = { navController.navigate("Devices") }
            )
        }


        composable(deviceScreen) {
            DeviceScreen (
                onNavigateToConfigScreen = { type ->
                    navController.navigate("Configuration Screen/$type")
                }
            )
        }

        composable(favouritesScreen){
            RoutinesScreen(
                onNavigateToDevicesScreen = { navController.navigate("Devices") }
            )
        }

        composable(placesScreen) {
            PlacesScreen(
                onNavigateToDevicesScreen = { navController.navigate("Routines") }
            )
        }

        composable("Configuration Screen/{type}") { backStackEntry ->
            val type = backStackEntry.arguments?.getInt("type")
            val device = DeviceLight("my luz")
            DeviceConfigScreen(device)
        }


        //DEVICES SCREENS

    }
}