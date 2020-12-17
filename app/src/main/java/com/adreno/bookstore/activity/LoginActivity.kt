package com.adreno.bookstore.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adreno.bookstore.R
import com.adreno.bookstore.util.SessionManager
import com.adreno.bookstore.util.Validations

class LoginActivity : AppCompatActivity() {


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtRegisterYourself: TextView


    lateinit var sessionManager: SessionManager
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)


        sessionManager = SessionManager(this)
        sharedPreferences =
            this.getSharedPreferences(sessionManager.PREF_NAME, sessionManager.PRIVATE_MODE)

        txtRegisterYourself.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }



        btnLogin.setOnClickListener {
            val mobile: String = etMobileNumber.text.toString()
            val password: String = etPassword.text.toString()
            if(Validations.validateMobile(mobile) and Validations.validatePasswordLength(password)) {
                sessionManager.setLogin(true)
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this,"Please enter valid details", Toast.LENGTH_SHORT).show()
        }
    }
}
