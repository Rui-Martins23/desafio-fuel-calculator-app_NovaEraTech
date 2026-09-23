package com.example.fuelcalculatorchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fuelcalculatorchallenge.R
import com.example.fuelcalculatorchallenge.ui.theme.FuelCalculatorChallengeTheme
import com.example.fuelcalculatorchallenge.ui.theme.FuelNavy
import com.example.fuelcalculatorchallenge.ui.theme.FuelWhite

@Composable
fun IllustrationBackground(
    image: Int = R.drawable.icon_location_main,
    imgContentDescription: String = "imagem principal da tela",
    imgOffsetY: Dp = 80.dp,
    imgOffsetX: Dp = 0.dp
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
                        bottomStart = 124.dp,
                        bottomEnd = 248.dp
                    )
                )
        )
        Image(
            painter = painterResource(
                id = image
            ),
            contentDescription = imgContentDescription,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = imgOffsetX, y = imgOffsetY)
                .width(220.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IllustrationBackgroundPreview() {
    FuelCalculatorChallengeTheme {
        IllustrationBackground()
    }
}