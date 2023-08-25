package com.techieblossom.kfcm.ui.features.team.list.model

import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.features.model.ListState

data class TeamUiState(
    val teams: List<Team> = emptyList(),
    var listState: ListState = ListState.LOADING,
)
