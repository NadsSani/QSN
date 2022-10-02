package com.whytecreations.qsn.ui.advert

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentAddAnAdvert1Binding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*

class AddAnAdvert1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddAnAdvert1Binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_add_an_advert1,container,false
        )
        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
        val imagebuttonspare = binding.imageView48
       // imagebuttonspare.setBackgroundResource(R.drawable.bg_layout_for_clickedadverticon)
        binding.imageView48.setColorFilter(
            ContextCompat.getColor(requireContext(), R.color.qsnyellow),
            PorterDuff.Mode.SRC_IN);
        val imagebuttoncar = binding.imageView47
        imagebuttoncar.setOnClickListener {
            findNavController().navigate(R.id.addAnAdvert)
        }
        toolbar.menu.clear()
        fortoolbar()
        return binding.root
    }
    private fun fortoolbar() {
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Add Advert"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.equalizer.isVisible = false
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