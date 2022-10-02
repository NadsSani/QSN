package com.whytecreations.qsn.ui.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentSubCategoriesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class SubCategories : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentSubCategoriesBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_sub_categories,container,false)
        val navBar: BottomNavigationView = requireActivity().findViewById(com.whytecreations.qsn.R.id.bottomNavigationViewmain)
        navBar.isVisible = false
        return binding.root
    }

}