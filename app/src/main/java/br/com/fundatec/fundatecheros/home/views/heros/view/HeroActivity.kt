package br.com.fundatec.fundatecheros.home.views.heros.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityHerosBinding
import br.com.fundatec.fundatecheros.gone
import br.com.fundatec.fundatecheros.home.views.heros.presentation.HeroViewModel
import br.com.fundatec.fundatecheros.home.views.heros.presentation.model.HeroViewState
import br.com.fundatec.fundatecheros.home.views.home.view.HomeActivity
import br.com.fundatec.fundatecheros.home.views.profile.model.ProfileViewState
import br.com.fundatec.fundatecheros.visible
import com.google.android.material.snackbar.Snackbar

private const val DELAY_TELA = 3000L

class HeroActivity : AppCompatActivity() {

    private val heroViewModel: HeroViewModel by viewModels()
    private lateinit var binding: ActivityHerosBinding

    val Personagem = arrayOf("Personagem", "Herói", "Vilão")
    val Universo = arrayOf("Universo", "Marvel", "DC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHerosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configButtonCreateHero()
        spinnerTypeHero()
        spinnerTypeUniverse()
    }

    private fun configButtonCreateHero() {
        binding.buttonCreateNewHero.setOnClickListener {
            heroViewModel.validateInputs(
                binding.nameHero.text.toString(),
                binding.descripion.text.toString(),
                binding.urlImage.text.toString(),
                binding.typeHero.selectedItemPosition,
                binding.typeFranchise.selectedItemPosition,
                binding.ageHero.text.toString(),
                binding.birthdayHero.text.toString(),
            )
        }

        heroViewModel.state.observe(this) {
            when (it) {

                HeroViewState.Loading -> binding.pbLoader.visible()

                HeroViewState.ShowNameError -> showNameError()

                HeroViewState.ShowDescriptionError -> showDescriptionError()

                HeroViewState.ShowImageError -> showImageError()

                HeroViewState.ShowUniverseTypeError -> showHeroTypeError()

                HeroViewState.ShowCharacterTypeError -> showUniverseTypeError()

                HeroViewState.ShowAgeError -> showAgeError()

                HeroViewState.ShowBirthdayError -> showBirthdayError()

                HeroViewState.ShowGenericError -> showError()

                HeroViewState.ShowHomeScreen -> TelaHome()

            }
        }
    }

    private fun showNameError() {
        binding.pbLoader.gone()
        binding.nameHero.error = getString(R.string.report_nameHero)
    }

    private fun showDescriptionError() {
        binding.pbLoader.gone()
        binding.descripion.error = getString(R.string.report_description)
    }

    private fun showImageError() {
        binding.pbLoader.gone()
        binding.urlImage.error = getString(R.string.report_url_image)
    }

    private fun showAgeError() {
        binding.pbLoader.gone()
        binding.ageHero.error = getString(R.string.report_age)
    }

    private fun showBirthdayError() {
        binding.pbLoader.gone()
        binding.birthdayHero.error = getString(R.string.report_birthday)
    }

    private fun showError() {
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root, R.string.hero_created_error, Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showHeroTypeError() {
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root, R.string.hero_type_error, Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showUniverseTypeError() {
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root, R.string.universe_type_error, Snackbar.LENGTH_LONG
        ).show()
    }

    private fun TelaHome() {
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root,
            R.string.sucess_hero_create, Snackbar.LENGTH_LONG
        ).show()

        val handle = Handler()
        handle.postDelayed({
            finish()
        }, DELAY_TELA)
    }

    private fun spinnerTypeHero() {
        val spinner = binding.typeHero
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            Personagem
        )
        spinner.adapter = arrayAdapter
    }

    private fun spinnerTypeUniverse() {
        val spinner = binding.typeFranchise
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            Universo
        )
        spinner.adapter = arrayAdapter
    }
}