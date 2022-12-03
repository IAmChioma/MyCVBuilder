package com.example.mycvbuilder

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun register(view: View) {

        val spf = getSharedPreferences("login", Context.MODE_PRIVATE)

        val spe = spf.edit()

        spe.putString("name", username.text.toString())
        spe.putString("pass", password.text.toString())
        spe.putString("phone", phone_number.text.toString())
        spe.putString("email", email.text.toString())
        spe.apply()
        Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show()

        finish()
    }

}