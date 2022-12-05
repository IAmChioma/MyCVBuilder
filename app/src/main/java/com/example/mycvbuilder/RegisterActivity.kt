package com.example.mycvbuilder

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun register(view: View) {
        val uname = username.text.toString().trim()
        val pwd = password.text.toString().trim()
        val phone = phone_number.text.toString().trim()
        val mail = email.text.toString().trim()

        if (uname.isEmpty() || pwd.isEmpty() || phone.isEmpty() || mail.isEmpty()) {
            if (uname.isEmpty())
                username.error = "Please enter username"

            if (phone.isEmpty())
                phone_number.error = "Please enter Phone Number"

            if (mail.isEmpty())
                email.error = "Please enter Email address"

            if (pwd.isEmpty())
                password.error = "Please enter Password"
        } else {

            val spf = getSharedPreferences("login", Context.MODE_PRIVATE)

            val spe = spf.edit()

            spe.putString("name", uname)
            spe.putString("pass", pwd)
            spe.putString("phone", phone)
            spe.putString("email", mail)
            spe.apply()
            Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show()

            finish()
        }
    }

}