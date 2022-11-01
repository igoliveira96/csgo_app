package br.com.goulart.csgo.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.goulart.csgo.data.match.usecase.GetMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        getMatches()
    }

    private fun getMatches() {
        _state.update { it.copy(loading = true) }
        viewModelScope.launch {
            getMatchesUseCase(
                params = GetMatchesUseCase.Params(
                    page = 1,
                    perPage = 10
                ),
                onSuccess = { matches ->
                    _state.update {
                        it.copy(matches = matches, loading = false)
                    }
                },
                onError = {
                    _state.update { it.copy(loading = false) }
                    Log.e("MATCHES", it.message.toString())
                }
            )
        }
    }

}