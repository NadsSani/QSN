package com.whytecreations.qsn.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible

import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentMyProfileBinding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class MyProfile : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMyProfileBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_my_profile,container,false
        )


        fortoolbar()
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner){
                requireActivity().toolbar.isVisible = true
                findNavController().navigateUp()

            }
        return binding.root

    }

    private fun fortoolbar() {
        requireActivity().toolbar.isVisible = false
        requireActivity().bottomNavigationViewmain.isVisible = true

    }


}