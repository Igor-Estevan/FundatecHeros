package br.com.fundatec.fundatecheros.home.views.login.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheros.home.views.home.view.HomeActivity
import br.com.fundatec.fundatecheros.home.views.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheros.home.views.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheros.home.views.profile.view.PofileActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Validando e-mail e senha
//        binding.buttonLogin.setOnClickListener {
//            viewModel.validateInputs(
//                binding.email.text.toString(),
//                binding.password.text.toString()
//            )
//        }

        binding.buttonLogin.setOnClickListener {
            val Home = Intent(this, HomeActivity::class.java)
            startActivity(Home)
        }

        binding.newUser.setOnClickListener {
            val newUser = Intent(this, PofileActivity::class.java)
            startActivity(newUser)
        }

        viewModel.state.observe(this) {
            when (it) {
                is LoginViewState.Success -> TODO()
                is LoginViewState.Error -> TODO()
                LoginViewState.Loading -> TODO()
                LoginViewState.ShowEmailError ->
                    showEmailError()

                LoginViewState.ShowPasswordError ->
                    showPasswordError()
            }
        }
    }

    private fun showEmailError() {
        binding.email.error = "Digite um e-mail válido"
    }

    private fun showPasswordError() {
        binding.password.error = "Digite uma senha válido"
    }

}