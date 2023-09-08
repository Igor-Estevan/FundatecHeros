package br.com.fundatec.fundatecheros.home.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.R
import br.com.fundatec.fundatecheros.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val Home = Intent(this, HomeActivity::class.java)
            startActivity(Home)
        }

        binding.newUser.setOnClickListener {
            val newUser = Intent(this, PofileActivity::class.java)
            startActivity(newUser)
        }

    }
}