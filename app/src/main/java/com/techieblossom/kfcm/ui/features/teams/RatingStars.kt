package com.techieblossom.kfcm.ui.features.teams

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
    calculateStars(rating).let {
        Row(modifier = modifier) {
            repeat(it.toInt()) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.filled_star),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
            }
            if (hasHalfStars) Image(
                imageVector = ImageVector.vectorResource(R.drawable.half_filled_star),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 2.dp)
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
fun PreviewRatingStars() {
    FCMTheme {
        RatingStars(66)
    }
}
