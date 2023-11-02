package br.com.fundatec.fundatecheros.home.views.profile.view

import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheros.home.views.profile.model.ProfileViewState
import br.com.fundatec.fundatecheros.home.views.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheros.home.views.splash.view.SplashActivity
import com.google.android.material.snackbar.Snackbar

class PofileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        nameFocusListener()
//        emailFocusListener()
//        passwordFocusListener()

//        binding.buttonCreateNewUser.setOnClickListener { submitForm() }

        viewModel.state.observe(this) {
            when (it) {
                ProfileViewState.Success ->
                    showSnackMessage("Sucesso ao criar o usuário")

                ProfileViewState.Error ->
                    showSnackMessage("Ocorreu um erro ao criar o usuário")

                ProfileViewState.Loading -> TODO()
                ProfileViewState.ShowNameError ->
                    showNameError()

                ProfileViewState.ShowEmailError ->
                    showEmailError()

                ProfileViewState.ShowPasswordError ->
                    showPasswordError()
            }
        }

        configBtCreateUser()
    }

    private fun configBtCreateUser() {
        binding.buttonCreateNewUser.setOnClickListener {
            viewModel.validateInputs(
                name = binding.UserName.text.toString(),
                email = binding.email.text.toString(),
                password = binding.password.text.toString(),
            )
        }
    }

    private fun showNameError() {
        binding.UserName.error = getString(R.string.report_name)
    }

    private fun showEmailError() {
        binding.email.error = getString(R.string.report_email)
    }

    private fun showPasswordError() {
        binding.password.error = getString(R.string.report_password)
    }

    private fun showSnackMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

}

//    private fun submitForm() {
//        val validName = binding.tilName.helperText == null
//        val validEmail = binding.tilEmail.helperText == null
//        val validPassword = binding.tilPassword.helperText == null
//
//        if (validName && validEmail && validPassword)
//            resetForm()
//        else
//            invalidForm()
//    }
//
//    private fun resetForm() {
//        Snackbar.make(
//            binding.buttonCreateNewUser,
//            getString(R.string.user_created), Snackbar.LENGTH_LONG
//        ).show()
//        Handler().postDelayed({
//            run() {
//                SplashActivity().time()
//            }
//        }, 3000)
//    }
//
//    private fun invalidForm() {
//        Snackbar.make(binding.buttonCreateNewUser, "Preencha todos os campos", Snackbar.LENGTH_LONG)
//            .show()
//    }
//
//    private fun nameFocusListener() {
//        binding.UserName.setOnFocusChangeListener { _, focused ->
//            if (!focused) {
//                binding.tilName.helperText = validName()
//            }
//        }
//    }
//
//    private fun validName(): String? {
//
//        if (binding.UserName.text.toString().isEmpty()) {
//            return "Preencha seu nome"
//        }
//
//        return null
//
//    }
//
//    private fun emailFocusListener() {
//        binding.email.setOnFocusChangeListener { _, focused ->
//            if (!focused) {
//                binding.tilEmail.helperText = validEmail()
//            }
//        }
//    }
//
//    private fun validEmail(): String? {
//
//        val emailText = binding.email.text.toString()
//        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
//            return "Email Inválido"
//        }
//
//        return null
//
//    }
//
//    private fun passwordFocusListener() {
//        binding.password.setOnFocusChangeListener { _, focused ->
//            if (!focused) {
//                binding.tilPassword.helperText = validPassword()
//            }
//        }
//    }
//
//    private fun validPassword(): String? {
//
//        if (binding.password.text.toString().length < 8) {
//            return "Sua senha deve conter mais de 8 caracteres"
//        }
//
//        return null
//
//    }


