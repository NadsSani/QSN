package com.whytecreations.qsn.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentLanguageChangeBinding

class LanguageChange : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLanguageChangeBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_language_change,container,false
        )
        return binding.root
    }


}