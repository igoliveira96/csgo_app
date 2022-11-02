package br.com.goulart.csgo.data.match.datasource

import androidx.paging.PagingSource
import br.com.goulart.csgo.data.match.model.Match

internal abstract class MatchDataSource : PagingSource<Int, Match>()