package com.adreno.bookstore.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adreno.bookstore.R
import com.adreno.bookstore.activity.OrderPlacedActivity

lateinit var btnOrdernow4: Button
class Book4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book4)
        btnOrdernow=findViewById(R.id.btnOrderNow4)
        btnOrdernow.setOnClickListener{
            val intent= Intent(this, OrderPlacedActivity::class.java)
            startActivity(intent)
        }
    }
}