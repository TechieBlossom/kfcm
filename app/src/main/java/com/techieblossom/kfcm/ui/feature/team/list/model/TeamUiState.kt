package com.techieblossom.kfcm.ui.feature.team.list.model

import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.feature.model.ListState

data class TeamUiState(
    val teams: List<Team> = emptyList(),
    var listState: ListState = ListState.LOADING,
)
