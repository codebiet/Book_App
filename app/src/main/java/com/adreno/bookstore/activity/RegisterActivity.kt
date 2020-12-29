package com.adreno.bookstore.activity

import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.adreno.bookstore.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")




        toolbar = findViewById(R.id.toolbarr)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Register Yourself"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitleTextAppearance(this, R.style.PoppinsTextAppearance)

        register()


        }

        private fun register() {
            btnRegister.setOnClickListener {

                when {
                    TextUtils.isEmpty(etName.text.toString()) -> {
                        etName.error = "Please enter first name "
                        return@setOnClickListener
                    }
                    TextUtils.isEmpty(etEmail.text.toString()) -> {
                        etEmail.error = "Please enter last name "
                        return@setOnClickListener
                    }
                    TextUtils.isEmpty(etPhoneNumber.text.toString()) -> {
                        etPhoneNumber.error = "Please enter user name "
                        return@setOnClickListener
                    }
                    TextUtils.isEmpty(etPassword.text.toString()) -> {
                        etPassword.error = "Please enter password "
                        return@setOnClickListener
                    }
                    else -> auth.createUserWithEmailAndPassword(
                        etEmail.text.toString(),
                        etPassword.text.toString()
                    )
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val currentUser = auth.currentUser
                                val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                                currentUSerDb?.child("firstname")
                                    ?.setValue(etName.text.toString())
                                currentUSerDb?.child("lastname")
                                    ?.setValue(etPhoneNumber.text.toString())

                                Toast.makeText(
                                    this,
                                    "Registration Success. ",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()

                            } else {
                                Toast.makeText(
                                    this,
                                    "Registration failed, please try again! ",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }
            }
        }
    }

