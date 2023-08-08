package com.techieblossom.kfcm.data.models

@kotlinx.serialization.Serializable
data class TeamMinimal(
    val id: Int,
    val name: String? = null,
    val overall: Int? = null,
)
