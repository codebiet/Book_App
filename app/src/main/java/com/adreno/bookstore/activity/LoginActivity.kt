package com.adreno.bookstore.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adreno.bookstore.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if (currentuser != null) {
            if (currentuser.isEmailVerified) {
                startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
                finish()
            }
        }
        login()
    }

    private fun login() {

        btnLogin.setOnClickListener {

            if (TextUtils.isEmpty(etLoginEmail.text.toString())) {
                etLoginEmail.error = "Please enter email"
                return@setOnClickListener
            } else if (TextUtils.isEmpty(etPassword.text.toString())) {
                etLoginEmail.error = "Please enter password"
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(
                etLoginEmail.text.toString(),
                etPassword.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val user = auth.currentUser

                        if (user != null) {
                            if (user.isEmailVerified) {
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        DashboardActivity::class.java
                                    )
                                )
                                finish()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Please verify your email address! ",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }

                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Login failed, please try again! ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }


        }
            txtRegisterYourself.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))

            }

    }}
