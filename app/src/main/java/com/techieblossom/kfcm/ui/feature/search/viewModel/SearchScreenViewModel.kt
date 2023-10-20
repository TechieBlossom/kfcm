package com.techieblossom.kfcm.ui.feature.search.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techieblossom.kfcm.data.getPlayerByName
import com.techieblossom.kfcm.data.getTeamMinimalByName
import com.techieblossom.kfcm.ui.navigation.RouteConstants
import com.techieblossom.kfcm.ui.feature.model.ListState
import com.techieblossom.kfcm.ui.feature.search.SearchEntity
import com.techieblossom.kfcm.ui.feature.search.model.SearchResult
import com.techieblossom.kfcm.ui.feature.search.model.SearchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchScreenViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val searchEntity = SearchEntity.valueOf(checkNotNull(savedStateHandle[RouteConstants.SEARCH_ENTITY]))

    private val _searchUiState = MutableStateFlow(SearchUiState())
    val searchUiState = _searchUiState.asStateFlow()

    fun search(searchTerm: String) {
        _searchUiState.update {
            it.copy(
                resultIdentifier = emptyList(),
                listState = ListState.IDLE
            )
        }
        if (searchTerm.length > 2) {
            when (searchEntity) {
                SearchEntity.Team -> doSearchTeam(searchTerm)
                SearchEntity.Player -> doSearchPlayer(searchTerm)
            }
        }
    }

    private fun doSearchTeam(searchTerm: String) {
        _searchUiState.update {
            it.copy(
                listState = ListState.LOADING
            )
        }
        viewModelScope.launch {
            val results = getTeamMinimalByName(searchTerm)
            _searchUiState.update {
                it.copy(
                    resultIdentifier = results.map { team ->
                        SearchResult(id = team.id, name = team.name!!)
                    },
                    listState = if (results.isEmpty()) ListState.EMPTY else ListState.IDLE
                )
            }
        }
    }

    private fun doSearchPlayer(searchTerm: String) {
        _searchUiState.update {
            it.copy(
                listState = ListState.LOADING
            )
        }
        viewModelScope.launch {
            val results = getPlayerByName(searchTerm)
            _searchUiState.update {
                it.copy(
                    resultIdentifier = results.map { player ->
                        SearchResult(id = player.id, name = player.name!!)
                    },
                    listState = if (results.isEmpty()) ListState.EMPTY else ListState.IDLE
                )
            }
        }
    }
}