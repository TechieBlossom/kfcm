package com.techieblossom.kfcm.ui.theme.shapes

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class HexagonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.width/2
        val path = Path()
        val points = mutableListOf<Offset>()
        repeat(6) {
            val degree = it * 60
            points.add(
                Offset(
                    radius.times(cos(PI * 2 * degree / 360)).toFloat(),
                    radius.times(sin(PI * 2 * degree / 360)).toFloat()
                ) + center
            )
        }

        path.apply {
            moveTo(points.first().x, points.first().y)
            points.forEach {
                lineTo(it.x, it.y)
            }
            close()
        }
        return Outline.Generic(path)
    }
}