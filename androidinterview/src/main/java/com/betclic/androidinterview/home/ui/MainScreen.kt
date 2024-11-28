package com.betclic.androidinterview.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MainScreen(
    viewModel: MainViewModel,
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        when (state) {
            is MainViewState.Loading -> {
                item {
                    Text(
                        text = "Loading...",
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
            is MainViewState.Error -> {
                item {
                    Text(
                        text = (state as MainViewState.Error).message,
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
            is MainViewState.Success -> {
                items((state as MainViewState.Success).playersViewState) { playerViewState ->
                    PlayerItem(
                        name = playerViewState.name,
                        club = playerViewState.club,
                        position = playerViewState.position,
                        imageUrl = playerViewState.photo,
                    )
                }
            }
        }
    }
}

@Composable
private fun PlayerItem(
    name: String,
    club: String,
    position: String,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = club,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = position,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PlayerItemPreview() {
    MaterialTheme {
        PlayerItem(
            name = "Zinedine Zidane",
            club = "Real Madrid",
            position = "Midfielder",
            imageUrl = "",
        )
    }
}