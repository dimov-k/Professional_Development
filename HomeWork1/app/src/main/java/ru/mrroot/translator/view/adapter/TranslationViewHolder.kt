package ru.mrroot.translator.view.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.mrroot.translator.databinding.ViewTranslationBinding
import ru.mrroot.translator.view.TranslationViewModel

class TranslationViewHolder(val binding: ViewTranslationBinding) : ViewHolder(binding.root) {

    fun bind(translation: TranslationViewModel, delegate: TranslationsAdapter.Delegate?) {
        with(binding) {
            translationText.text = translation.text
            root.setOnClickListener {
                delegate?.onTranslationPicked(translation)
            }
        }
    }

}