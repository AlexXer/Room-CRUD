package com.alexxer.crud.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alexxer.crud.R
import com.alexxer.crud.model.User
import com.alexxer.crud.viewModel.UserViewModel
import kotlinx.android.synthetic.main.custom_rv_item.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updateFirstName_et.setText(args.currentUser.firstName)
        view.updateLastName_et.setText(args.currentUser.lastName)
        view.updateAge_et.setText(args.currentUser.age.toString())

        view.update_btn.setOnClickListener {
            updateUser()
        }

        return view
    }

    fun updateUser() {
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateFirstName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())
        if (inputCheck(firstName, lastName, updateAge_et.text)) {
            // Create User Object
            val updatedUser = User(args.currentUser.id, firstName, lastName, age)
            //Update current User
            mUserViewModel.update(updatedUser)
            Toast.makeText(requireContext(),"Updated successfully!", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }
        else{
            Toast.makeText(requireContext(),"Please fill out all fields!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}