package com.techieblossom.kfcm.ui.features.team.list.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techieblossom.kfcm.data.getTeams
import com.techieblossom.kfcm.ui.features.team.list.model.ListState
import com.techieblossom.kfcm.ui.features.team.list.model.TeamUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TeamScreenViewModel : ViewModel() {
    private val _teamsUiState = MutableStateFlow(TeamUiState())
    val teamUiState = _teamsUiState.asStateFlow()

    private var page = 0
    var canPaginate by mutableStateOf(false)

    init {
        loadTeams()
    }

    fun loadTeams() {
        Log.i("PAGE", page.toString())
        viewModelScope.launch {
            if (page == 0 || (canPaginate) && _teamsUiState.value.listState == ListState.IDLE) {
                val listState = if (page == 0) ListState.LOADING else ListState.PAGINATING
                _teamsUiState.update {
                    it.copy(
                        listState = listState
                    )
                }
            }

            val localTeams = getTeams(page, ITEMS_PER_PAGE)
            if (page == 0) {
                _teamsUiState.update {
                    it.copy(
                        teams = localTeams,
                        listState = ListState.IDLE
                    )
                }
            } else {
                _teamsUiState.update {
                    it.copy(
                        teams = it.teams + localTeams,
                        listState = ListState.IDLE
                    )
                }
            }

            page = _teamsUiState.value.teams.size / 10
            canPaginate = true
        }
    }

    fun onSearch(searchTerm: String) {
        if (searchTerm.length > 2) {
            Log.d("onSearch","Start search")
        }
    }

    override fun onCleared() {
        page = 0
        _teamsUiState.value.listState = ListState.IDLE
        canPaginate = false
        super.onCleared()
    }

    companion object {
        const val ITEMS_PER_PAGE = 10L
    }
}