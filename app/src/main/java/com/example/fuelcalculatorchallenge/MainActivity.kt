package com.example.fuelcalculatorchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fuelcalculatorchallenge.presentation.carConsumption.CarConsumptionScreen
import com.example.fuelcalculatorchallenge.presentation.distance.DistanceScreen
import com.example.fuelcalculatorchallenge.presentation.finalAmount.FinalAmountScreen
import com.example.fuelcalculatorchallenge.presentation.fuelPrice.FuelPriceScreen
import com.example.fuelcalculatorchallenge.presentation.splash.SplashScreen
import com.example.fuelcalculatorchallenge.ui.Screen
import com.example.fuelcalculatorchallenge.ui.theme.FuelCalculatorChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FuelCalculatorChallengeTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val sharedViewModel: FuelCalculatorViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Tela 1: Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(
                onIniciarClick = {navController.navigate(Screen.FuelPrice.route)}
            )
        }

        // Tela 2: Fuel Price
        composable(Screen.FuelPrice.route) {
            FuelPriceScreen(
                onProximoClick = { fuelPrice ->
                    sharedViewModel.setFuelPrice(fuelPrice)
                    navController.navigate(Screen.CarConsumption.route)
                }
            )
        }

        // Tela 3: Car Consumption
        composable(Screen.CarConsumption.route) {
            CarConsumptionScreen(
                onProximoClick = { carConsumption ->
                    sharedViewModel.setCarConsumption(carConsumption)
                    navController.navigate(Screen.Distance.route)
                }
            )
        }

        // Tela 4: Distance
        composable(Screen.Distance.route) {
            DistanceScreen(
                onProximoClick = { distance ->
                    sharedViewModel.setDistance(distance)
                    sharedViewModel.calculateFuelPrice()
                    navController.navigate(Screen.FinalAmount.route)
                }
            )
        }

        // Tela 5: Final Amount
        composable(Screen.FinalAmount.route) {
            FinalAmountScreen(
                sharedViewModel = sharedViewModel,
                onNovoCalculoClick = {
                    sharedViewModel.setFuelPrice("")
                    sharedViewModel.setCarConsumption("")
                    sharedViewModel.setDistance("")
                    navController.navigate(Screen.Splash.route)
                }
            )
        }
    }
}