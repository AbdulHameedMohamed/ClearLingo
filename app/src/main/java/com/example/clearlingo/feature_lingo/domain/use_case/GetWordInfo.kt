package com.example.clearlingo.feature_lingo.domain.use_case

import com.example.clearlingo.core.util.Resource
import com.example.clearlingo.feature_lingo.domain.model.WordInfo
import com.example.clearlingo.feature_lingo.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if(word.isBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}