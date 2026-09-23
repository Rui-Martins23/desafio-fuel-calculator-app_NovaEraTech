package com.example.fuelcalculatorchallenge.presentation.finalAmount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fuelcalculatorchallenge.FuelCalculatorViewModel
import com.example.fuelcalculatorchallenge.ui.theme.FuelBlue
import com.example.fuelcalculatorchallenge.ui.theme.FuelCalculatorChallengeTheme
import com.example.fuelcalculatorchallenge.ui.theme.FuelNavy
import com.example.fuelcalculatorchallenge.ui.theme.FuelWhite

@Composable
fun FinalAmountScreen(
    modifier: Modifier = Modifier,
    sharedViewModel: FuelCalculatorViewModel,
    onNovoCalculoClick: () -> Unit = {}
) {
    val fuelPrice by sharedViewModel.fuelPrice
    val carConsumption by sharedViewModel.carConsumption
    val distance by sharedViewModel.distance
    val totalSpent by sharedViewModel.totalSpent

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FuelNavy)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(FuelNavy)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        FuelWhite,
                        RoundedCornerShape(
                            bottomStart = 62.dp,
                            bottomEnd = 62.dp
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = totalSpent,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Área abaixo da Box branca
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = 24.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 24.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Revisão dos dados inseridos",
                    color = FuelWhite,
                    fontSize = 24.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Preço",
                        color = FuelWhite.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 36.sp
                    )
                    Text(
                        text = "$$fuelPrice",
                        color = FuelWhite.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 36.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Consumo",
                        color = FuelWhite.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 36.sp
                    )
                    Text(
                        text = carConsumption,
                        color = FuelWhite.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 36.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Kms",
                        color = FuelWhite.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 36.sp
                    )
                    Text(
                        text = distance,
                        color = FuelWhite.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 36.sp
                    )
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = onNovoCalculoClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(FuelBlue),
                elevation = ButtonDefaults.buttonElevation(4.dp)
            ) {
                Text(
                    text = "Novo Cálculo",
                    fontSize = 16.sp
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun FinalAmountScreenPreview() {
    FuelCalculatorChallengeTheme {
        FinalAmountScreen(
            sharedViewModel = FuelCalculatorViewModel()
        )
    }
}*/
