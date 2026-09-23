package com.example.fuelcalculatorchallenge.presentation.carConsumption

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fuelcalculatorchallenge.R
import com.example.fuelcalculatorchallenge.ui.components.IllustrationBackground
import com.example.fuelcalculatorchallenge.ui.theme.FuelBlue
import com.example.fuelcalculatorchallenge.ui.theme.FuelBlueDark
import com.example.fuelcalculatorchallenge.ui.theme.FuelCalculatorChallengeTheme
import com.example.fuelcalculatorchallenge.ui.theme.FuelNavy
import com.example.fuelcalculatorchallenge.ui.theme.FuelPink
import com.example.fuelcalculatorchallenge.ui.theme.FuelWhite

@Composable
fun CarConsumptionScreen(
    modifier: Modifier = Modifier,
    onProximoClick: (String) -> Unit = {}
) {
    var carConsumption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FuelNavy)
    ) {
        IllustrationBackground(
            image = R.drawable.icon_car,
            imgContentDescription = "imagem de carro",
            imgOffsetY = 100.dp
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = 48.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 24.dp
                )
        ) {
            Text(
                text = "Consumo do Carro",
                color = FuelWhite,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Passo 2 de 3",
                color = FuelPink,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = carConsumption,
                onValueChange = { userInput -> carConsumption = userInput },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("Km por litro") },
                placeholder = { Text("Ex: 5")},
                shape = RoundedCornerShape(4.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = FuelBlueDark,
                    unfocusedContainerColor = FuelBlueDark.copy(alpha = 0.7f),
                    focusedLabelColor = FuelWhite,
                    unfocusedLabelColor = FuelWhite,
                    focusedPlaceholderColor = FuelWhite.copy(alpha = 0.7f),
                    unfocusedPlaceholderColor = FuelWhite.copy(alpha = 0.7f)
                )
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = { onProximoClick(carConsumption) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(FuelBlue),
                elevation = ButtonDefaults.buttonElevation(4.dp)
            ) {
                Text(
                    text = "Próximo",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarConsumptionScreenPreview() {
    FuelCalculatorChallengeTheme {
        CarConsumptionScreen()
    }
}