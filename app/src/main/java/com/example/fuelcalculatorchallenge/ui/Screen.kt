package com.example.fuelcalculatorchallenge.ui

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object FuelPrice: Screen("fuel_price_screen")
    object CarConsumption: Screen("car_consumption_screen")
    object Distance: Screen("distance_screen")
    object FinalAmount: Screen("final_amount_screen")
}