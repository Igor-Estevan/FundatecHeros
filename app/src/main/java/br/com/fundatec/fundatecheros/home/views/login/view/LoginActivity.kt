package br.com.fundatec.fundatecheros.home.views.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheros.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheros.home.views.home.view.HomeActivity
import br.com.fundatec.fundatecheros.home.views.profile.view.PofileActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
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