package com.techieblossom.kfcm.ui.feature.player.detail.model

import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.data.models.TeamMinimal
import com.techieblossom.kfcm.ui.feature.model.DetailState

data class PlayerDetailUiState(
    var player: Player,
    var clubTeamInfo: TeamMinimal? = null,
    var nationalTeamInfo: TeamMinimal? = null,
    var detailState: DetailState = DetailState.LOADING,
)