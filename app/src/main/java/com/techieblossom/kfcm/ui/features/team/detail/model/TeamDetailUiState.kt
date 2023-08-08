package com.techieblossom.kfcm.ui.features.team.detail.model

import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.features.model.DetailState

data class TeamDetailUiState(
    var team: Team,
    var detailState: DetailState = DetailState.LOADING,
    var formation: Formation? = null,
)