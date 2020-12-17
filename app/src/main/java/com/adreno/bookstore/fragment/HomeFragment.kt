package com.adreno.bookstore.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.adreno.bookstore.R
import com.adreno.bookstore.util.*


class HomeFragment : Fragment() {

    private lateinit var clBook1: ConstraintLayout
    private lateinit var clBook2: ConstraintLayout
    private lateinit var clBook3: ConstraintLayout
    private lateinit var clBook4: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as DrawerLocker).setDrawerEnabled(true)

        clBook1=view.findViewById(R.id.clBook1)
        clBook2=view.findViewById(R.id.clBook2)
        clBook3=view.findViewById(R.id.clBook3)
        clBook4=view.findViewById(R.id.clBook4)


        clBook1.setOnClickListener {

            val intent = Intent(activity as Context, Book1Activity::class.java)
            startActivity(intent)
            intent.putExtra("name","Book1")
        }
        clBook2.setOnClickListener {

            val intent = Intent(activity as Context, Book2Activity::class.java)
            startActivity(intent)
            intent.putExtra("name" ,"Book2")
        }
        clBook3.setOnClickListener {

            val intent = Intent(activity as Context, Book3Activity::class.java)
            startActivity(intent)
            intent.putExtra("name","Book3")
        }
        clBook4.setOnClickListener {

            val intent = Intent(activity as Context, Book4Activity::class.java)
            startActivity(intent)
            intent.putExtra("name","Book4")
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.dashboard_menu, menu)
    }



}
