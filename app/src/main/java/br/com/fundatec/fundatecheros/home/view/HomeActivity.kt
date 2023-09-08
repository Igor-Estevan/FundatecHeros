package br.com.fundatec.fundatecheros.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.gone
import br.com.fundatec.fundatecheros.home.presentation.model.HomeViewState

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



