package com.whytecreations.qsn.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentHomeActivityBinding


class HomeActivity : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentHomeActivityBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home_activity, container, false)
//        binding.homeviewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        //travel
        binding.textView.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeActivity_to_signIn)
        })



        return binding.root
    }


}