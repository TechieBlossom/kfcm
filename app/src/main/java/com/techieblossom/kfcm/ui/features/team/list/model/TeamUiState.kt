package com.techieblossom.kfcm.ui.features.team.list.model

import com.techieblossom.kfcm.data.models.Team

data class TeamUiState(
    val teams: List<Team> = emptyList(),
    var listState: ListState = ListState.LOADING,
)
