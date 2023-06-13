package com.example.smarthouse_tp3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.smarthouse_tp3.ui.theme.SmartHouse_tp3Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHouse_tp3Theme() {
                val navController = rememberNavController()
                var showBottomBar by rememberSaveable { mutableStateOf(true) }
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                showBottomBar = when (navBackStackEntry?.destination?.route) {
                    "Favourites" -> false // on this screen bottom bar should be hidden
                    "RouteOfScreenB" -> false // here too
                    else -> true // in all other cases show bottom bar
                }

                Scaffold(
                    bottomBar = { if (showBottomBar) BottomBar(navController = navController) },
                    topBar = { if (showBottomBar) BottomBar(navController = navController) }
                ) {
                    MyNavHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun CartItemStateless(
    quantity: Int,                      //  state
    incrementQuantity: () -> Unit,       //event
    decrementQuantity: () -> Unit
){
    Row {
        Text( text = "Cart item:")
        Button(
            onClick = { incrementQuantity() },
        ) {
            Text(text = "+")
        }
        Button(onClick = { decrementQuantity() }) {
            Text(text = "-")
        }
        Text(text = quantity.toString())
    }
}

@Composable
fun BottomBar(
    navController: NavController
){
    val items = listOf(
        MainScreen.FavouritesScreen,
        MainScreen.RoutinesScreen,
        MainScreen.DevicesScreen,
        MainScreen.PlacesScreen
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = ImageVector.vectorResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }


}




/* --------------------- LAS PREVIEW EMPIEZAN ACA ------------------*/

//@Preview (showBackground = true)
@Composable
fun CartItemStatelessPreview(){
    var quantity: Int by remember { mutableStateOf(1) }

    CartItemStateless(
        quantity,
        {quantity++},
        {quantity--}
    )
}

@Preview
@Composable
fun BottomBarPreview(){
    val navController = rememberNavController()
    BottomBar(navController = navController)
}
