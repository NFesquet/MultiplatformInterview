package com.betclic.androidinterview.home.ui

import androidx.lifecycle.ViewModel
import com.betclic.interview.home.domain.PlayersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    playersRepository: PlayersRepository,
) : ViewModel() {

}