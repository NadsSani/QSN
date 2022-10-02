package com.whytecreations.qsn.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentMenuBinding


class Menu : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMenuBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_menu,container,false
        )
        return binding.root
    }


}