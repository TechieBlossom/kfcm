package com.techieblossom.kfcm.ui.feature.search.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techieblossom.kfcm.ui.feature.model.ListState
import com.techieblossom.kfcm.ui.feature.search.model.SearchResult
import com.techieblossom.kfcm.ui.feature.search.model.SearchUiState
import com.techieblossom.kfcm.ui.theme.FCMTheme

@Composable
fun SearchSuggestions(
    searchUiState: SearchUiState,
    modifier: Modifier = Modifier,
    onItemTap: (id: Int) -> Unit,
) {
    return when (searchUiState.listState) {
        ListState.LOADING -> {
            Column(
                modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }

        ListState.IDLE -> {
            SearchSuggestionsList(
                results = searchUiState.resultIdentifier,
                onItemTap = onItemTap,
                modifier = modifier,
            )
        }

        ListState.EMPTY -> {
            Text(
                text = "No results for search. Try changing search text.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(16.dp),
            )
        }

        else -> {}
    }
}

@Composable
fun SearchSuggestionsList(
    results: List<SearchResult>,
    modifier: Modifier = Modifier,
    onItemTap: (id: Int) -> Unit,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(2.dp)) {
        results.map { result ->
            Text(
                text = result.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(role = Role.Button) {
                        onItemTap(result.id)
                    }
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview_SearchResult_IDLE() {
    FCMTheme {
        Surface {
            SearchSuggestions(
                searchUiState = SearchUiState(
                    resultIdentifier = listOf(
                        SearchResult(1, "FS Barcelona"),
                        SearchResult(1, "FS Barcelona"),
                        SearchResult(1, "FS Barcelona"),
                        SearchResult(1, "FS Barcelona"),
                    )
                ),
                onItemTap = { }
            )
        }
    }
}

@Preview
@Composable
fun Preview_SearchResult_LOADING() {
    FCMTheme {
        Surface {
            SearchSuggestions(
                searchUiState = SearchUiState(
                    resultIdentifier = listOf(),
                    listState = ListState.LOADING
                ),
                onItemTap = {}
            )
        }
    }
}

@Preview
@Composable
fun Preview_SearchResult_EMPTY() {
    FCMTheme {
        Surface {
            SearchSuggestions(
                searchUiState = SearchUiState(
                    resultIdentifier = listOf(),
                    listState = ListState.EMPTY
                ),
                onItemTap = { }
            )
        }
    }
}