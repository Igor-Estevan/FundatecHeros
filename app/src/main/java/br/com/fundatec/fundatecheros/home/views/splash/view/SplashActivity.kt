package br.com.fundatec.fundatecheros.home.views.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.home.views.home.view.HomeActivity
import br.com.fundatec.fundatecheros.home.views.login.view.LoginActivity
import br.com.fundatec.fundatecheros.home.views.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheros.home.views.splash.presentation.SplashViewModel
import br.com.fundatec.fundatecheros.home.views.splash.presentation.model.SplashViewState

private const val DELAY_SHOW_SCREEN = 3000L

class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.state.observe(this) { state ->
            when (state) {
                SplashViewState.ShowLogin -> showLogin()
                SplashViewState.ShowHome -> showHome()
            }
        }
    }
    private fun showLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
    }
    private fun showHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
    }
}