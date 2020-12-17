package com.adreno.bookstore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adreno.bookstore.R
lateinit var btnOkay: Button
class OrderPlacedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)
            btnOkay = findViewById(R.id.btnOk)

            btnOkay.setOnClickListener {
                val homeIntent = Intent(this, DashboardActivity::class.java)
                startActivity(homeIntent)
                finish()
            }

        }

        override fun onBackPressed() {
            val homeIntent = Intent(this, DashboardActivity::class.java)
            startActivity(homeIntent)
            finish()
        }

}