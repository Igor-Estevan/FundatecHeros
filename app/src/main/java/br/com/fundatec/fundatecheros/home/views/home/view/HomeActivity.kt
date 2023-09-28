package br.com.fundatec.fundatecheros.home.views.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheros.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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



