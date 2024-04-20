package com.example.clearlingo.feature_lingo.domain.repository

import com.example.clearlingo.core.util.Resource
import com.example.clearlingo.feature_lingo.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}