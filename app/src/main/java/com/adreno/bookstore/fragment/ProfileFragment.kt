package com.adreno.bookstore.fragment


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

import com.adreno.bookstore.R
import com.adreno.bookstore.util.DrawerLocker

class ProfileFragment : Fragment() {

    private lateinit var txtUserName: TextView
    private lateinit var txtPhone: TextView
    private lateinit var txtEmail: TextView
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        (activity as DrawerLocker).setDrawerEnabled(true)
        sharedPrefs = (activity as FragmentActivity).getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        txtUserName = view.findViewById(R.id.txtUserName)
        txtPhone = view.findViewById(R.id.txtPhone)
        txtEmail = view.findViewById(R.id.txtEmail)
        //Using shared preference to get details
        val username = sharedPrefs.getString("name", "User Name")
        val email = sharedPrefs.getString("email", "example@example.com")
        val mobileNumber = sharedPrefs.getString("mobileNumber", "9876543210")


        txtUserName.text = username
        txtPhone.text = mobileNumber
        txtEmail.text = email
        return view
    }

}
