package com.techieblossom.kfcm.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.utility.domain.calculateColor
import com.techieblossom.kfcm.utility.domain.prepareValueAndColorWithDelta
import com.techieblossom.kfcm.utility.domain.dashIfNullOrBlank
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun RatingValue(value: Int?, valueStyle: TextStyle = MaterialTheme.typography.labelSmall) {
    val color = calculateColor(value)
    Box(
        modifier = Modifier
            .size(24.dp)
            .border(width = 2.dp, color, shape = RoundedCornerShape(2.dp))
            .padding(1.dp)
            .background(color),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = (value ?: 0).toString(),
            style = valueStyle,
            color = Color.White,
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RatingValue(value: String?, valueStyle: TextStyle = MaterialTheme.typography.labelSmall) {
    val (color, newValue, delta) = prepareValueAndColorWithDelta(value)

    color.let {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .border(width = 2.dp, it, shape = RoundedCornerShape(4.dp))
                    .padding(1.dp)
                    .background(it),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = newValue.dashIfNullOrBlank(),
                    style = valueStyle,
                    color = Color.White,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            }
            if (delta != null) {
                Text(
                    text = delta.dashIfNullOrBlank(),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}


@Preview
@Composable
fun Preview_RatingValueInt() {
    FCMTheme {
        Surface {
            RatingValue(82)
        }
    }
}

@Preview
@Composable
fun Preview_RatingValueStringIncrement() {
    FCMTheme {
        Surface {
            RatingValue("82+2")
        }
    }
}

@Preview
@Composable
fun Preview_RatingValueString() {
    FCMTheme {
        Surface {
            RatingValue("67")
        }
    }
}

@Preview
@Composable
fun Preview_RatingValueWithStringSingleDigit() {
    FCMTheme {
        Surface {
            RatingValue("6+2")
        }
    }
}