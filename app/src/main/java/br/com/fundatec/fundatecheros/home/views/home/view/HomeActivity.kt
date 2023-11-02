package br.com.fundatec.fundatecheros.home.views.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheros.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheros.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheros.home.domain.CharacterModel
import br.com.fundatec.fundatecheros.home.views.Heros.view.HerosActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val adapter: CharacterListAdapter by lazy { CharacterListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addHero.setOnClickListener {
            val CreateHero = Intent(this, HerosActivity::class.java)
            startActivity(CreateHero)
        }

        binding.rvList.adapter = adapter
        adapter.addList(
            listOf(
                CharacterModel(
                    name = "Deadpool",
                    image = "https://t.ctcdn.com.br/sCcEQtGDmgOulA-eyYCYrHUJ8HA=/640x360/smart/i397070.jpeg",
                ),
                CharacterModel(
                    name = "Miranha",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRJoKu_umGCqwAnoSOtQJOTGacMCcIMzdbSw&usqp=CAU",
                ),
                CharacterModel(
                    name = "Goku",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiLUfQzPX9nL3QFlKewqVIrSLXYbdhlRqBiQ&usqp=CAU",
                ),
                CharacterModel(
                    name = "Caneta Azul",
                    image = "https://rondoniaovivo.com/imagensNoticias/WhatsAppImage2023-04-27at08.50.54.jpeg?id=280163",
                )
            )
        )
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



