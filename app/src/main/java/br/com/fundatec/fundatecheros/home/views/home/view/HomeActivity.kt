package br.com.fundatec.fundatecheros.home.views.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheros.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheros.home.views.heros.view.HeroActivity
import br.com.fundatec.fundatecheros.home.views.home.presentation.HomeViewModel
import br.com.fundatec.fundatecheros.home.views.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val adapter: CharacterListAdapter by lazy { CharacterListAdapter() }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addHero.setOnClickListener {
            val CreateHero = Intent(this, HeroActivity::class.java)
            startActivity(CreateHero)
        }

        binding.rvList.adapter = adapter
        viewModel.state.observe(this) {
            when(it) {
                is HomeViewState.Sucess -> adapter.addList(
                    it.list
                )
                HomeViewState.Loading -> {}

                is HomeViewState.Error -> it.errorMessage
                else -> {}
            }
        }
    }
}

//    private val button by lazy {
//        findViewById<Button>(R.id.button)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//
//        observerState(HomeViewState.hideButton)
//    }
//
//    private fun observerState(state: HomeViewState) {
//        when (state) {
//            is HomeViewState.Sucess -> {
//                state.message
//            }
//
//            is HomeViewState.Error -> {
//                state.errorMessage
//            }
//
//            HomeViewState.Loading -> {}
//
//            else -> {
//                button.gone()
//            }
//        }
//    }



