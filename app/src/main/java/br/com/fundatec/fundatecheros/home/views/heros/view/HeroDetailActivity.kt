package br.com.fundatec.fundatecheros.home.views.heros.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityDetailsHeroBinding
import br.com.fundatec.fundatecheros.home.views.home.domain.HeroModel

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsHeroBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val character = intent.extras?.getSerializable("character") as? HeroModel
        if (character == null) {
            finish()
            return
        }
        binding.nameHero.text = character.name
        binding.textDescricaoPersonagem.text =
            getString(R.string.hero_detail_description, character.description)
        binding.textIdadePersonagem.text =
            getString(R.string.hero_detail_age, character.age.toString())
        binding.textNascimentoPersonagem.text =
            getString(R.string.hero_detail_birthday, character.date)
    }
}