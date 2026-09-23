package com.example.fuelcalculatorchallenge.ui.components

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class WhiteBlobShape : Shape {
    // Nunca usada neste projeto... através do Modifier.click(WhiteBlobShape())
    // Arredondando os cantos simplesmente através do RoundedCornerShape teve o mesmo resultado

    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path()

        val width = size.width
        val height = size.height

        // Começamos no canto superior esquerdo
        path.moveTo(0f, 0f)

        // Topo
        path.lineTo(width, 0f)

        // Lado direito
        path.lineTo(width, height * 0.12f)

        // Curva superior/direita
        path.cubicTo(
            width * 0.99f,
            height * 0.30f,

            width * 0.91f,
            height * 0.45f,

            width * 0.76f,
            height * 0.55f
        )

        // Curva central
        path.cubicTo(
            width * 0.61f,
            height * 0.65f,

            width * 0.57f,
            height * 0.75f,

            width * 0.43f,
            height * 0.80f
        )

        // Curva inferior/esquerda
        path.cubicTo(
            width * 0.25f,
            height * 0.87f,

            width * 0.08f,
            height * 0.78f,

            0f,
            height * 0.63f
        )

        // Voltar ao início
        path.close()

        return Outline.Generic(path)
    }
}