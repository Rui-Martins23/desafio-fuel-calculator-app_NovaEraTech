package com.example.fuelcalculatorchallenge

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FuelCalculatorViewModel: ViewModel() {
    private val _totalSpent = mutableStateOf("")
    val totalSpent = _totalSpent

    private val _fuelPrice = mutableStateOf("")
    val fuelPrice = _fuelPrice

    private val _carConsumption = mutableStateOf("")
    val carConsumption = _carConsumption

    private val _distance = mutableStateOf("")
    val distance = _distance

    fun setFuelPrice(fuelPriceInput: String) {
        _fuelPrice.value = fuelPriceInput
    }

    fun setCarConsumption(carConsumptionInput: String) {
        _carConsumption.value = carConsumptionInput
    }

    fun setDistance(distanceInput: String) {
        _distance.value = distanceInput
    }

    fun calculateFuelPrice() {
        // Transformação de string para double para poder realizar o cálculo da val amountSpent
        val fuelPrice = _fuelPrice.value.toDoubleOrNull() ?: 0.0
        val carConsumption = _carConsumption.value.toDoubleOrNull() ?: 0.0
        val distance = _distance.value.toDoubleOrNull() ?: 0.0

        val amountSpent = (distance / carConsumption) * fuelPrice

        val amountSpentFormatted = amountSpent.toString()

        _totalSpent.value = "$$amountSpent"
    }
}