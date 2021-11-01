package ru.mrroot.translator.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.mrroot.translator.view.TranslationViewModel
import ru.mrroot.translator.R.layout.view_translation
import ru.mrroot.translator.databinding.ViewTranslationBinding

class TranslationsAdapter(private val delegate: Delegate?) :
    ListAdapter<TranslationViewModel, TranslationViewHolder>(TranslationDiff) {
    interface Delegate {
        fun onTranslationPicked(translation: TranslationViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslationViewHolder =
        TranslationViewHolder(
            ViewTranslationBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: TranslationViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}