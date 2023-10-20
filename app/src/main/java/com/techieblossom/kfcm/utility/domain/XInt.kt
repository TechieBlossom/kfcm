package com.techieblossom.kfcm.utility.domain

fun Int?.dashIfNull(): String = this?.toString() ?: "-"
fun Int?.zeroIfNull(): Int = this?.toInt() ?: 0
