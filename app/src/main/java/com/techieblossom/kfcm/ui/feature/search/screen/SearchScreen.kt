package com.techieblossom.kfcm.ui.feature.search.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techieblossom.kfcm.ui.composable.SearchComponent
import com.techieblossom.kfcm.ui.feature.model.ListState
import com.techieblossom.kfcm.ui.feature.search.SearchEntity
import com.techieblossom.kfcm.ui.feature.search.composable.SearchSuggestions
import com.techieblossom.kfcm.ui.feature.search.viewModel.SearchScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onTeamSuggestionTap: (id: Int) -> Unit,
    onPlayerSuggestionTap: (id: Int) -> Unit,
    onBackPressed: () -> Unit,
) {
    val viewModel = viewModel<SearchScreenViewModel>()
    val searchUiState by viewModel.searchUiState.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Search", style = MaterialTheme.typography.titleLarge)
            },
            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowLeft, contentDescription = "")
                }
            },
        )
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            SearchComponent(
                hint = hintText(viewModel.searchEntity),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            ) {
                viewModel.search(it)
            }
            AnimatedVisibility(
                visible = searchUiState.listState == ListState.IDLE || searchUiState.listState == ListState.EMPTY,
                exit = fadeOut(
                    animationSpec = tween(2000)
                )
            ) {
                SearchSuggestions(
                    searchUiState = searchUiState, onItemTap = { id ->
                        when (viewModel.searchEntity) {
                            SearchEntity.Team -> onTeamSuggestionTap(id)
                            SearchEntity.Player -> onPlayerSuggestionTap(id)
                        }
                    }, modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

private fun hintText(searchEntity: SearchEntity) = when (searchEntity) {
    SearchEntity.Team -> "Barcelona, Real Madrid..."
    SearchEntity.Player -> "Messi, Ronaldo, Haaland, Mbappe..."
}