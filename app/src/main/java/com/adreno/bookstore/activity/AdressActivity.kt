package com.adreno.bookstore.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.adreno.bookstore.R


class AdressActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var recyclerCart: RecyclerView

    private lateinit var txtResName: TextView
    private lateinit var rlLoading: RelativeLayout
    private lateinit var rlCart: RelativeLayout
    private lateinit var btnPlaceOrder: Button
    private var resId: Int = 0
    private var resName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        init()
        setupToolbar()
        placeOrder()
    }


    private fun init() {
        rlLoading = findViewById(R.id.rlLoading)
        rlCart = findViewById(R.id.rlCart)

        val bundle = intent.getBundleExtra("data")
        resId = bundle?.getInt("resId", 0) as Int
        resName = bundle.getString("resName", "") as String
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbarr)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "My Cart"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitleTextAppearance(this, R.style.PoppinsTextAppearance)
    }




    private fun placeOrder() {
        btnPlaceOrder = findViewById(R.id.btnConfirmOrder)

        /*Before placing the order, the user is displayed the price or the items on the button for placing the orders*/
        var sum = 0

        val total = "Place Order(Total: Rs. $sum)"
        btnPlaceOrder.text = total

        btnPlaceOrder.setOnClickListener {
            rlLoading.visibility = View.VISIBLE
            rlCart.visibility = View.INVISIBLE
        }
    }


}
