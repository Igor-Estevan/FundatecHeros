package br.com.fundatec.fundatecheros.home.views.profile.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheros.gone
import br.com.fundatec.fundatecheros.home.views.login.view.LoginActivity
import br.com.fundatec.fundatecheros.home.views.profile.model.ProfileViewState
import br.com.fundatec.fundatecheros.home.views.profile.presentation.ProfileViewModel
import br.com.fundatec.fundatecheros.visible
import com.google.android.material.snackbar.Snackbar

private const val DELAY_SHOW_SCREEN = 3000L

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            when (it) {
                ProfileViewState.Error -> showError()
                ProfileViewState.Loading -> binding.pbLoader.visible()
                ProfileViewState.ShowNameError -> showNameError()
                ProfileViewState.ShowEmailError -> showEmailError()
                ProfileViewState.ShowPasswordError -> showPasswordError()
                ProfileViewState.Success -> showSuccess()
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
        binding.pbLoader.gone()
        binding.UserName.error = getString(R.string.report_name)
    }

    private fun showEmailError() {
        binding.pbLoader.gone()
        binding.email.error = getString(R.string.report_email)
    }

    private fun showPasswordError() {
        binding.pbLoader.gone()
        binding.password.error = getString(R.string.report_password)
    }

    private fun showSuccess() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
            finish()
        }, DELAY_SHOW_SCREEN)
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root, R.string.user_created, Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showError() {
        binding.pbLoader.gone()
        Snackbar.make(
            binding.root, R.string.user_created_error, Snackbar.LENGTH_LONG
        ).show()
    }

}

