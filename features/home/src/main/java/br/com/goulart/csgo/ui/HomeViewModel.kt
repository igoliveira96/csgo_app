package br.com.goulart.csgo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import br.com.goulart.csgo.data.match.model.Match
import br.com.goulart.csgo.data.match.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MatchRepository,
) : ViewModel() {

    fun getMatches(): Flow<PagingData<Match>> {
        return repository.getMatches().cachedIn(viewModelScope)
    }
}