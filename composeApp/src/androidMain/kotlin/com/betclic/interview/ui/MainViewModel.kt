package com.betclic.interview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betclic.interview.home.domain.usecase.GetPlayersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//@HiltViewModel
class MainViewModel(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    private var _stateFlow: MutableStateFlow<MainViewState> =
        MutableStateFlow(MainViewState(emptyList()))
    val stateFlow: StateFlow<MainViewState>
        get() = _stateFlow

    init {
        viewModelScope.launch {
            val players = MainViewState(
                players = getPlayersUseCase.invoke().map { player ->
                    PlayerViewState(
                        name = player.name,
                        position = player.position,
                        club = player.club,
                        imageUrl = player.photo,
                    )
                }
            )

            _stateFlow.emit(players)
        }
    }
}

data class MainViewState(
    val players: List<PlayerViewState>
)

data class PlayerViewState(
    val name: String,
    val position: String,
    val club: String,
    val imageUrl: String,
)