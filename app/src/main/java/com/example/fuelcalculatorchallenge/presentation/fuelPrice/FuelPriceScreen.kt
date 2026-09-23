package com.example.fuelcalculatorchallenge.presentation.fuelPrice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.KeyboardType
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
fun FuelPriceScreen(
    modifier: Modifier = Modifier,
    onProximoClick: (String) -> Unit = {}
) {
    var fuelPrice by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FuelNavy)
    ) {
        IllustrationBackground(
            image = R.drawable.icon_price_screen,
            imgContentDescription = "imagem de ecrã com sinal $",
            imgOffsetY = 70.dp
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
                text = "Preço do Combustível",
                color = FuelWhite,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Passo 1 de 3",
                color = FuelPink,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = fuelPrice,
                onValueChange = { userInput ->
                    // Valida a entrada: aceita apenas números e até um ponto decimal
                    if (userInput.isEmpty() || userInput.matches(Regex("^\\d*\\.?\\d*$"))) {
                        fuelPrice = userInput
                        // Reseta o estado de erro para falso, assim que o utilizador começa a corrigir
                        if (isError) { isError = false}
                    }
                },
                // 3. Define o tipo de teclado apenas para números decimais
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                // Ativa a aparência visual de erro, se isError = true (borda/fundo destacados a vermelho)
                isError = isError,
                // 5. Exibe a mensagem de erro por baixo do TextField
                supportingText = {
                    if (isError) {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("Preço por litro") },
                placeholder = { Text("Ex: 1.70")},
                shape = RoundedCornerShape(4.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = FuelBlueDark,
                    unfocusedContainerColor = FuelBlueDark.copy(alpha = 0.7f),
                    focusedLabelColor = FuelWhite,
                    unfocusedLabelColor = FuelWhite,
                    focusedPlaceholderColor = FuelWhite.copy(alpha = 0.7f),
                    unfocusedPlaceholderColor = FuelWhite.copy(alpha = 0.7f),

                    // Personalização das cores de erro
                    errorContainerColor = FuelBlueDark,
                    errorLabelColor = MaterialTheme.colorScheme.error,
                    errorIndicatorColor = MaterialTheme.colorScheme.error
                )
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    // Validação ao clicar no botão "Próximo"
                    val priceNumber = fuelPrice.toDoubleOrNull()

                    when {
                        fuelPrice.isBlank() -> {
                            isError = true
                            errorMessage = "Por favor, preencha o valor."
                        }
                        priceNumber == null -> {
                            isError = true
                            errorMessage = "Insira um número válido."
                        }
                        priceNumber <= 0.0 -> {
                            isError = true
                            errorMessage = "O valor deve ser maior que zero."
                        }
                        else -> {
                            isError = false
                            onProximoClick(fuelPrice)
                        }
                    }
                },
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
fun FuelPriceScreenPreview() {
    FuelCalculatorChallengeTheme {
        FuelPriceScreen()
    }
}