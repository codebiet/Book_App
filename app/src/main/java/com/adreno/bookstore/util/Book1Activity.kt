package com.adreno.bookstore.util

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adreno.bookstore.R
import com.adreno.bookstore.activity.OrderPlacedActivity
import com.adreno.bookstore.activity.btnOrderNow
lateinit var btnOrdernow: Button
class Book1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book1)
        btnOrdernow=findViewById(R.id.btnOrderNow)
        btnOrdernow.setOnClickListener{
            val intent= Intent(this, OrderPlacedActivity::class.java)
            startActivity(intent)
        }
    }
}