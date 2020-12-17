package com.adreno.bookstore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.adreno.bookstore.R
lateinit var imgBook:ImageView
lateinit var txtBookname:TextView
lateinit var txtBookprice:TextView
lateinit var txtBookDesc:TextView
lateinit var btnOrderNow:Button
 var bookSelected: String?="Hello"
class BookDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        bookSelected= intent.getStringExtra("name")
        imgBook=findViewById(R.id.imgBook)
        txtBookname=findViewById(R.id.txtBookname)
        txtBookprice=findViewById(R.id.txtBookprice)
        txtBookDesc=findViewById(R.id.txtBookDesc)
        btnOrderNow=findViewById(R.id.btnOrderNow)
        /*This data transfer through intent is not working
        if(bookSelected=="1"){
            txtBookname.text="Let Uc C#"
            txtBookprice.text="Rs. 299"
            txtBookDesc.text=getString(R.string.book1_desc)
        }*/

        //There is also a address activity but right now It's not working.
        //Will update the code after successful run
        btnOrderNow.setOnClickListener{
            val intent=Intent(this,OrderPlacedActivity::class.java)
            startActivity(intent)
        }
    }
}