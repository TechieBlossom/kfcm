package com.techieblossom.kfcm.ui.feature.search.model

import com.techieblossom.kfcm.ui.feature.model.ListState

data class SearchUiState(
    val resultIdentifier: List<SearchResult> = emptyList(),
    var listState: ListState = ListState.IDLE
)