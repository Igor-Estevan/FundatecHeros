package br.com.fundatec.fundatecheros.home.views.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheros.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheros.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheros.home.views.Heros.view.HerosActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addHero.setOnClickListener {
            val CreateHero = Intent(this, HerosActivity::class.java)
            startActivity(CreateHero)
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



