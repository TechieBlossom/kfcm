package com.techieblossom.kfcm.ui.features.team.list.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.R
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun RatingStars(rating: Int, modifier: Modifier = Modifier) {
    val stars = calculateStars(rating)
    val hasHalfStars = hasHalfStars(stars)
    stars.let {
        Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            repeat(it.toInt()) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.filled_star),
                    contentDescription = null,
                )
            }
            if (hasHalfStars) Image(
                imageVector = ImageVector.vectorResource(R.drawable.half_filled_star),
                contentDescription = null,
            )
        }
    }
}

private fun hasHalfStars(stars: Double) = (stars * 2).rem(2).toInt() == 1

private fun calculateStars(number: Int): Double {
    return when {
        number >= 83 -> 5.0
        number >= 79 -> 4.5
        number >= 75 -> 4.0
        number >= 71 -> 3.5
        number >= 69 -> 3.0
        number >= 67 -> 2.5
        number >= 66 -> 2.0
        number >= 63 -> 1.5
        number >= 60 -> 1.0
        else -> 0.5
    }
}

@Preview
@Composable
fun Preview_RatingStars() {
    FCMTheme {
        Surface {
            RatingStars(80)
        }
    }
}
