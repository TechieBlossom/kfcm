package com.techieblossom.kfcm.ui

fun Int?.dashIfNull(): String = this?.toString() ?: "-"
fun Int?.zeroIfNull(): Int = this?.toInt() ?: 0
