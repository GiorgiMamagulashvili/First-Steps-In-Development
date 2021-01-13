package com.example.roomdatabase.fragment.add

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class addFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = name_et.text.toString()
        val lastName = last_name_et.text.toString()
        val age = age_et.text
        if (inputCheck(name, lastName, age!!)) {
            val user = User(0,name,lastName,Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "warmatebit daemata monacemebi", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "ver daemata monacemi", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(firstName: String, LastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(LastName) && age.isEmpty())
    }

}