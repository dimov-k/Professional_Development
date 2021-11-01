package ru.mrroot.translator.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.mrroot.translator.App
import ru.mrroot.translator.databinding.ActivityMainBinding
import ru.mrroot.translator.presenter.BasePresenter
import ru.mrroot.translator.view.adapter.TranslationsAdapter

class MainActivity : AppCompatActivity(), BaseView, TranslationsAdapter.Delegate {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: BasePresenter
    private val translationAdapter = TranslationsAdapter(delegate = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = App.instance.mainPresenter
        presenter.attachActivity(this)
        binding.translations.adapter = translationAdapter
        binding.inputLayoutSubject.setEndIconOnClickListener {
            presenter.getTranslation(binding.searchWord.text.toString())
        }
    }

    override fun setTranslationsForSearchWord(translations: List<TranslationViewModel>) {
        translationAdapter.submitList(translations)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.detachActivity()
        super.onDestroy()
    }

    override fun onTranslationPicked(translation: TranslationViewModel) {
        Toast.makeText(this, translation.text, Toast.LENGTH_SHORT).show()
    }
}