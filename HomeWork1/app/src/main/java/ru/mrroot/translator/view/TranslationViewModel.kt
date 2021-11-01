package ru.mrroot.translator.view

import ru.mrroot.translator.data.word.Meaning

data class TranslationViewModel(
    val id: Int = 0,
    val text: String = ""
) {
    object Mapper {
        fun map(meaning: Meaning) =
            TranslationViewModel(
                meaning.id,
                meaning.translation.text
            )
    }
}
