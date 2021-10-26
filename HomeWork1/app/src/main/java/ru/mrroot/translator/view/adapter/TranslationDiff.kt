package ru.mrroot.translator.view.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.mrroot.translator.view.TranslationViewModel

object TranslationDiff : DiffUtil.ItemCallback<TranslationViewModel>() {
    private val payload = Any()

    override fun areItemsTheSame(
        oldItem: TranslationViewModel,
        newItem: TranslationViewModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: TranslationViewModel,
        newItem: TranslationViewModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: TranslationViewModel, newItem: TranslationViewModel) =
        payload
}