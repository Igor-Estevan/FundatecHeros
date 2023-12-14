package br.com.fundatec.fundatecheros.home.views.login.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheros.gone
import br.com.fundatec.fundatecheros.visible
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheros.home.views.home.view.HomeActivity
import br.com.fundatec.fundatecheros.home.views.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheros.home.views.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheros.home.views.profile.view.ProfileActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configButtonLogin()
        configNewHereButton()

        viewModel.state.observe(this) {
            when (it) {
                LoginViewState.ShowErrorMessage -> showSnackMessage()
                LoginViewState.Loading -> binding.pbLoader.visible()
                LoginViewState.ShowEmailError -> showEmailError()
                LoginViewState.ShowPasswordError -> showPasswordError()

                LoginViewState.ShowHomeScreen ->
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            }
        }
    }

    private fun configButtonLogin() {
        binding.buttonLogin.setOnClickListener {
            viewModel.validateInputs(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
        }
    }

    private fun configNewHereButton() {
        binding.newUser.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
        }
    }

    private fun showEmailError() {
        binding.pbLoader.gone()
        binding.email.error = getString(R.string.email_error)
    }

    private fun showPasswordError() {
        binding.pbLoader.gone()
        binding.password.error = getString(R.string.password_error)
    }

    private fun showSnackMessage() {
        binding.pbLoader.gone()

        Snackbar.make(
            binding.root,
            R.string.login_error,
            Snackbar.LENGTH_LONG
        ).show()
    }
}