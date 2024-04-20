package com.example.clearlingo.feature_lingo.data.remote.dto

import com.example.clearlingo.feature_lingo.domain.model.Meaning


data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}