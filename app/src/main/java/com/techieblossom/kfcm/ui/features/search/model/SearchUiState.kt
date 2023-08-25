package com.techieblossom.kfcm.ui.features.search.model

import com.techieblossom.kfcm.ui.features.model.ListState

data class SearchUiState(
    val resultIdentifier: List<SearchResult> = emptyList(),
    var listState: ListState = ListState.IDLE
)