package com.betclic.androidinterview.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betclic.interview.home.domain.PlayersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val playersRepository: PlayersRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<MainViewState> = MutableStateFlow(MainViewState.Loading)
    val state: StateFlow<MainViewState>
        get() = _state

    fun getPlayers() {
        viewModelScope.launch {
            val players = playersRepository.getPlayers()
            if (players.isEmpty()) {
                _state.value = MainViewState.Error("No players found")
            } else {
                _state.value = MainViewState.Success(
                    players.map {
                        PlayerViewState(
                            id = it.id,
                            name = it.name,
                            photo = it.photo,
                            club = it.club,
                            position = it.position,
                        )
                    }
                )
            }
        }
    }
}

sealed interface MainViewState {
    data object Loading : MainViewState
    data class Error(val message: String) : MainViewState
    data class Success(val playersViewState: List<PlayerViewState>) : MainViewState
}

data class PlayerViewState(
    val id: String,
    val name: String,
    val photo: String,
    val club: String,
    val position: String,
)