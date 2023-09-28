package br.com.fundatec.fundatecheros.home.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.databinding.ActivityProfileBinding
import com.google.android.material.snackbar.Snackbar

class PofileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var valido = true

        fun validatorName() {
            if (binding.UserName.text.toString().isEmpty()) {
                valido = false
                Snackbar.make(
                    binding.buttonCreateNewUser,
                    "Preencha seu nome",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                valido = true
            }

        }

        binding.buttonCreateNewUser.setOnClickListener {
            validatorName()
            if (valido === true) {
                Snackbar.make(
                    binding.buttonCreateNewUser,
                    "@string/user_created",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
        }
    }

}
