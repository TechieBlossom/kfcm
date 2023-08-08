package com.techieblossom.kfcm.ui

import androidx.compose.ui.geometry.times
import com.techieblossom.kfcm.calculateColor
import java.util.Locale

fun String?.dashIfNullOrBlank(): String = if (isNullOrBlank()) "-" else this
fun String?.blankIfNullOrBlank(): String = if (isNullOrBlank()) "" else this
fun String?.timesInt(other: Float): Int = this?.let {
    val plusIndex = it.indexOf("+")
    val minusIndex = it.indexOf("-")

    val result = when {
        plusIndex != -1 -> it.substring(0, plusIndex).toInt()
        minusIndex != -1 -> it.substring(0, minusIndex).toInt()
        else -> it.toInt()
    }
    result.times(other).toInt()
} ?: 0

fun String?.capitalize(): String? = this?.replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(
        Locale.getDefault()
    ) else it.toString()
}