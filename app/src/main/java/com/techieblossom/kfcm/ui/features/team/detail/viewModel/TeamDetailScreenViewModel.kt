package com.techieblossom.kfcm.ui.features.team.detail.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techieblossom.kfcm.data.getTeam
import com.techieblossom.kfcm.data.models.Team
import com.techieblossom.kfcm.ui.RouteConstants
import com.techieblossom.kfcm.ui.features.model.DetailState
import com.techieblossom.kfcm.ui.features.team.detail.model.TeamDetailUiState
import com.techieblossom.kfcm.ui.features.team.detail.usecase.getFormation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TeamDetailScreenViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val teamId: String = checkNotNull(savedStateHandle[RouteConstants.TEAM_ID])

    private val _teamUiState = MutableStateFlow(TeamDetailUiState(Team(teamId.toInt())))
    val teamUiState = _teamUiState.asStateFlow()

    init {
        loadTeam()
    }

    private fun loadTeam() {
        viewModelScope.launch {
            val team = getTeam(teamId.toInt())

            _teamUiState.update { teamDetailUiState ->
                teamDetailUiState.copy(
                    team = team,
                    detailState = DetailState.LOADED,
                    formation = getFormation(team.starting.let {
                        it?.map { starting ->
                            starting.position
                        }
                    }),
                )
            }
        }
    }

}