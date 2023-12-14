package br.com.fundatec.fundatecheros.home.views.heros.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityHerosBinding
import br.com.fundatec.fundatecheros.home.views.heros.presentation.HeroViewModel

private const val DELAY_TELA = 3000L
class HeroActivity : AppCompatActivity() {

    private val heroViewModel: HeroViewModel by viewModels()
    private lateinit var binding: ActivityHerosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHerosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinnerHero: Spinner = binding.typeHero

        ArrayAdapter.createFromResource(
            this,
            R.array.type_hero,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
//            adapter.setDropDownViewResource(binding.typeHero.dropDownWidth)
            spinnerHero.adapter = adapter
        }

        val spinnerFranchise: Spinner = binding.typeFranchise

        ArrayAdapter.createFromResource(
            this,
            R.array.type_franchise,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
//            adapter.setDropDownViewResource(binding.typeFranchise.dropDownWidth)
            spinnerFranchise.adapter = adapter
        }
    }
}