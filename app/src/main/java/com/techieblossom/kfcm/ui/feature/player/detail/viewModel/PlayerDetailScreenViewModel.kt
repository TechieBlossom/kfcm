package com.techieblossom.kfcm.ui.feature.player.detail.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techieblossom.kfcm.data.getPlayer
import com.techieblossom.kfcm.data.getTeamMinimal
import com.techieblossom.kfcm.data.models.Player
import com.techieblossom.kfcm.ui.navigation.RouteConstants
import com.techieblossom.kfcm.ui.feature.model.DetailState
import com.techieblossom.kfcm.ui.feature.player.detail.model.PlayerDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayerDetailScreenViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val playerId: String = checkNotNull(savedStateHandle[RouteConstants.PLAYER_ID])

    private val _playerUiState = MutableStateFlow(PlayerDetailUiState(Player(playerId.toInt())))
    val playerUiState = _playerUiState.asStateFlow()

    init {
        loadPlayer()
    }

    private fun loadPlayer() {
        viewModelScope.launch {
            val player = getPlayer(playerId.toInt())
            val clubTeamInfo = player.clubId?.let {
                getTeamMinimal(it)
            }
            val nationalTeamInfo = player.nationalTeamId?.let {
                getTeamMinimal(it)
            }
            _playerUiState.update { playerDetailUiState ->
                playerDetailUiState.copy(
                    player = player,
                    clubTeamInfo = clubTeamInfo,
                    nationalTeamInfo = nationalTeamInfo,
                    detailState = DetailState.LOADED,
                )
            }
        }
    }

}