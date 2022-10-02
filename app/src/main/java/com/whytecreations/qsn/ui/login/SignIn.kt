package com.whytecreations.qsn.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentSignInBinding


class SignIn : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSignInBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_sign_in, container, false)
//        binding.homeviewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initialized(binding)



        return binding.root
    }




    fun initialized(binding: FragmentSignInBinding){
        //travel
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }
        //forgot password page
        binding.forgetpasstext.setOnClickListener{
            findNavController().navigate(R.id.action_signIn_to_forgotPassword)
        }
        binding.signin.setOnClickListener{
            findNavController().navigate(R.id.action_signIn_to_dashBoardActivity)
        }
    }
}