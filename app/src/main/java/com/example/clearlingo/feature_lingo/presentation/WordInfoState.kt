package com.example.clearlingo.feature_lingo.presentation

import com.example.clearlingo.feature_lingo.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)