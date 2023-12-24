package br.com.fundatec.fundatecheros.home.views.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheros.gone
import br.com.fundatec.fundatecheros.home.views.heros.presentation.HeroViewModel
import br.com.fundatec.fundatecheros.home.views.heros.view.HeroActivity
import br.com.fundatec.fundatecheros.home.views.heros.view.HeroDetailActivity
import br.com.fundatec.fundatecheros.home.views.home.domain.HeroModel
import br.com.fundatec.fundatecheros.home.views.home.presentation.HomeViewModel
import br.com.fundatec.fundatecheros.home.views.home.presentation.model.HomeViewState
import br.com.fundatec.fundatecheros.visible
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val adapter: CharacterListAdapter by lazy { CharacterListAdapter() { heroDetail(it) } }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingsSwipeToRemove()

        binding.addHero.setOnClickListener {
            val CreateHero = Intent(this, HeroActivity::class.java)
            startActivity(CreateHero)
        }

        binding.rvList.adapter = adapter
        viewModel.state.observe(this) {
            when (it) {
                is HomeViewState.Sucess -> adapter.addList(
                    it.list,
                    binding.pbLoader.gone()
                )

                HomeViewState.Loading -> binding.pbLoader.visible()

                is HomeViewState.Error -> it.errorMessage

                is HomeViewState.HeroRemove -> showError()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.searchInfo()
    }

    private fun showError() {
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root, R.string.hero_delete_successful, Snackbar.LENGTH_LONG
        ).show()
    }

    private fun settingsSwipeToRemove() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                v: RecyclerView,
                h: RecyclerView.ViewHolder,
                t: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                val character = adapter.retrieveCharacter(h.adapterPosition)
                viewModel.removeHero(character.id)
                adapter.removeAt(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.rvList)
    }

    private fun heroDetail(heroModel: HeroModel) {
        val intent = Intent(this@HomeActivity, HeroDetailActivity::class.java)
        intent.putExtra("character", heroModel)
        startActivity(intent)
    }

}