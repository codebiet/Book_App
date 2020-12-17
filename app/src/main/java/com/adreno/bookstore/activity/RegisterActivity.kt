package com.adreno.bookstore.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.adreno.bookstore.R
import com.adreno.bookstore.util.SessionManager
import com.adreno.bookstore.util.Validations

class RegisterActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var btnRegister: Button
    lateinit var etName: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPassword: EditText
    lateinit var etEmail: EditText
    lateinit var etAddress: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var rlRegister: RelativeLayout
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        toolbar = findViewById(R.id.toolbarr)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Register Yourself"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitleTextAppearance(this, R.style.PoppinsTextAppearance)

        rlRegister = findViewById(R.id.rlRegister)
        etName = findViewById(R.id.etName)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etAddress = findViewById(R.id.etAddress)
        btnRegister = findViewById(R.id.btnRegister)


        sessionManager = SessionManager(this)
        sharedPreferences =
            this.getSharedPreferences(sessionManager.PREF_NAME, sessionManager.PRIVATE_MODE)

        btnRegister.setOnClickListener {

            val name: String = etName.text.toString()
            val phone: String = etPhoneNumber.text.toString()
            val email: String = etEmail.text.toString()
            val password : String = etPassword.text.toString()
            val cnfpassword: String = etConfirmPassword.text.toString()
            if(Validations.validateMobile(phone) and Validations.validateNameLength(name) and Validations.validateEmail(email) and
                   Validations.validatePasswordLength(password) and Validations.validatePasswordLength(cnfpassword) and Validations.matchPassword(password,cnfpassword)) {

                 sessionManager.setLogin(true)

                sharedPreferences.edit().putString("name", name)
                    .apply()
                sharedPreferences.edit()
                    .putString("email", email)
                    .apply()
                sharedPreferences.edit()
                    .putString("mobileNumber", phone)
                    .apply()

                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }
            else
                Toast.makeText(this,"Please enter valid details",Toast.LENGTH_SHORT).show()
        }
    }
}
