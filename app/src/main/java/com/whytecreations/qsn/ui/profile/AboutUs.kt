package com.whytecreations.qsn.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentAboutUsBinding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class AboutUs : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAboutUsBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_about_us,container,false
        )

        requireActivity().toolbar.menu.clear()
        fortoolbar()
        return binding.root
    }
    private fun fortoolbar() {
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "About Us"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().toolbar.equalizer.isVisible = false
        requireActivity().bottomNavigationViewmain.isVisible = false
        requireActivity().toolbar.setNavigationOnClickListener {
            toggle()
        }

    }
    private fun toggle() {
        if (requireActivity().drawerLayout.isDrawerVisible(GravityCompat.START)) {
            requireActivity().drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().drawerLayout.openDrawer(GravityCompat.START)
        }
    }

}