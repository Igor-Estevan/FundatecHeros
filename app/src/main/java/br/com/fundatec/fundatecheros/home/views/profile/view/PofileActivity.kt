package br.com.fundatec.fundatecheros.home.views.profile.view

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.databinding.ActivityProfileBinding
import com.google.android.material.snackbar.Snackbar

class PofileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameFocusListener()
        emailFocusListener()
        passwordFocusListener()


        binding.buttonCreateNewUser.setOnClickListener { submitForm() }

    }

    private fun submitForm() {
        val validName = binding.tilName.helperText == null
        val validEmail = binding.tilEmail.helperText == null
        val validPassword = binding.tilPassword.helperText == null

        if (validName && validEmail && validPassword)
            resetForm()
        else
            invalidForm()
    }

    private fun resetForm() {
        Snackbar.make(binding.buttonCreateNewUser, "Usuário Criado", Snackbar.LENGTH_LONG).show()
    }

    private fun invalidForm() {
        Snackbar.make(binding.buttonCreateNewUser, "Preencha todos os campos", Snackbar.LENGTH_LONG)
            .show()
    }

    private fun nameFocusListener() {
        binding.UserName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilName.helperText = validName()
            }
        }
    }

    private fun validName(): String? {

        if (binding.UserName.text.toString().isEmpty()) {
            return "Preencha seu nome"
        }

        return null

    }

    private fun emailFocusListener() {
        binding.email.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilEmail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {

        val emailText = binding.email.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Email Inválido"
        }

        return null

    }

    private fun passwordFocusListener() {
        binding.password.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {

        if (binding.password.text.toString().length < 8) {
            return "Sua senha deve conter mais de 8 caracteres"
        }

        return null

    }

}
