package com.techieblossom.kfcm.ui.feature.player.detail.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techieblossom.kfcm.utility.domain.calculatePlayerBriefStats
import com.techieblossom.kfcm.data.models.ActualPosition
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.ui.previewMocks.playerForCard
import com.techieblossom.kfcm.ui.theme.FCMTheme
import com.techieblossom.kfcm.ui.theme.rating1
import com.techieblossom.kfcm.ui.theme.rating2
import com.techieblossom.kfcm.ui.theme.rating3
import com.techieblossom.kfcm.ui.theme.rating4
import com.techieblossom.kfcm.ui.theme.rating5
import com.techieblossom.kfcm.ui.theme.shapes.HexagonShape
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Hexagon(modifier: Modifier, player: Player, labelSize: TextUnit) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val spaceForLabels = if(labelSize == 6.sp) 30.dp else 50.dp
        val hexagonMaxWidth = maxWidth - spaceForLabels
        val hexagonMaxWidthInPx = with(LocalDensity.current) { hexagonMaxWidth.toPx() }
        val radius = hexagonMaxWidthInPx / 2

        val playerStats = calculatePlayerBriefStats(player)
        val data = if (player.bestPosition == ActualPosition.GK)
            listOf(
                Pair("PAS", playerStats.pas),
                Pair("DRI", playerStats.dri),
                Pair("DEF", playerStats.def),
                Pair("PHY", playerStats.phy),
                Pair("PAC", playerStats.pac),
                Pair("SHO", playerStats.sho),
            )
        else listOf(
            Pair("PAS", playerStats.pas),
            Pair("DRI", playerStats.dri),
            Pair("DEF", playerStats.def),
            Pair("PHY", playerStats.phy),
            Pair("PAC", playerStats.pac),
            Pair("SHO", playerStats.sho),
        )

//        LayeredHexagon(hexagonMaxWidth = hexagonMaxWidth)
        Labels(
            modifier = Modifier.size(200.dp),
            hexagonMaxWidthInPx = hexagonMaxWidthInPx,
            data = data,
            labelSize = labelSize,
        )
        RatingHexagon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(hexagonMaxWidth),
            radius = radius,
            data = data,
        )
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun Labels(
    modifier: Modifier,
    hexagonMaxWidthInPx: Float,
    data: List<Pair<String, Int>>,
    labelSize: TextUnit,
) {
    val textStyle = MaterialTheme.typography.labelMedium.copy(
        textAlign = TextAlign.Center,
        fontSize = labelSize,
    )
    val textMeasurer = rememberTextMeasurer()
    val measurements = data.map {
        textMeasurer.measure(createLabel(it) ,style = textStyle,)
    }
    val radius = hexagonMaxWidthInPx / 2
    val center = Offset(hexagonMaxWidthInPx / 2, hexagonMaxWidthInPx / 2)
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

    Canvas(modifier = modifier) {
        drawText(
            topLeft = points[0] + Offset(
                measurements[0].size.width * 1.5f,
                measurements[0].size.height * 0.5f,
            ),
            textMeasurer = textMeasurer,
            text = createLabel(data[0]).text,
            style = textStyle,
        )
        drawText(
            topLeft = points[1] + Offset(
                measurements[1].size.width * 1f,
                measurements[1].size.height * 1f,
            ),
            textMeasurer = textMeasurer,
            text = createLabel(data[1]).text,
            style = textStyle,
        )
        drawText(
            topLeft = points[2] + Offset(
                measurements[2].size.width * 1f,
                measurements[2].size.height * 1f,
            ),
            textMeasurer = textMeasurer,
            text = createLabel(data[2]).text,
            style = textStyle,
        )
        drawText(
            topLeft = points[3] + Offset(
                measurements[3].size.width * 0.1f,
                measurements[3].size.height * 0.5f,
            ),
            textMeasurer = textMeasurer,
            text = createLabel(data[3]).text,
            style = textStyle,
        )
        drawText(
            topLeft = points[4] + Offset(
                measurements[4].size.width * 0.9f,
                measurements[4].size.height * -0.2f,
            ),
            textMeasurer = textMeasurer,
            text = createLabel(data[4]).text,
            style = textStyle,
        )
        drawText(
            topLeft = points[5] + Offset(
                measurements[5].size.width * 0.9f,
                measurements[5].size.height * -0.2f,
            ),
            textMeasurer = textMeasurer,
            text = createLabel(data[5]).text,
            style = textStyle,
        )
    }
}

private fun createLabel(pair: Pair<String, Int>) = buildAnnotatedString {
    append(pair.first)
    appendLine()
    append(pair.second.toString())
}

@Composable
fun BoxScope.LayeredHexagon(hexagonMaxWidth: Dp) {
    val ratingColors = listOf(rating5, rating4, rating3, rating2, rating1)

    ratingColors.forEachIndexed { index, color ->
        Box(
            modifier = Modifier
                .size(hexagonMaxWidth * (5 - index) / 5)
                .clip(HexagonShape())
                .background(color = color)
                .align(Alignment.Center)
        )
    }
}


@Composable
fun RatingHexagon(radius: Float, data: List<Pair<String, Int>>, modifier: Modifier) {
    val multipliers = mutableListOf<Float>()
    data.map {
        multipliers.add(it.second / 100f)
    }
    multipliers.add(data[0].second / 100f)

    val ratingPoints = mutableListOf<Offset>()
    repeat(7) {
        val degree = it * 60f
        ratingPoints.add(
            Offset(
                (multipliers[it]) * (radius).times(cos(PI * 2 * degree / 360))
                    .toFloat(),
                (multipliers[it]) * (radius).times(sin(PI * 2 * degree / 360))
                    .toFloat()
            )
        )
    }

    Canvas(modifier = modifier) {
        drawCircle(
            color = Color.DarkGray,
            radius = radius,

        )
        drawPoints(
            points = ratingPoints.map { it.plus(center) }.toList(),
            pointMode = PointMode.Polygon,
            color = Color.Green,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            pathEffect = PathEffect.cornerPathEffect(radius = 10f),
        )
    }

}

@Preview
@Composable
fun Preview_Hexagon() {
    FCMTheme {
        Surface {
            Hexagon(
                modifier = Modifier
                    .padding(8.dp)
                    .width(200.dp)
                    .height(200.dp),
                player = playerForCard,
                labelSize = 10.sp,
            )
        }
    }
}