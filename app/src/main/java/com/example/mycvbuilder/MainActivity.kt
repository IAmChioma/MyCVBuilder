package com.example.mycvbuilder

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    lateinit var spf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spf = getSharedPreferences("login", Context.MODE_PRIVATE)

        val name = spf.getString("name", "")
        val pwd = spf.getString("pass", "")
        username.setText(name)
        password.setText(pwd)
    }

    fun login(view: View) {

        val name = spf.getString("name", "no value")
        val pwd = spf.getString("pass", "no value")
        if ((name.equals(username.text.toString(), ignoreCase = true) && password.text.toString() == pwd)) {
            Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show();
            val it = Intent(this, DashboardActivity::class.java)
            startActivity(it)
        }
        else {
            Toast.makeText(applicationContext, "Failed to Login", Toast.LENGTH_LONG).show()
        }
    }
    fun register(view:View) {
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
    }
