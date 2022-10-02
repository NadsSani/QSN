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
import com.whytecreations.qsn.databinding.FragmentAddAnAdvertBinding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class AddAnAdvert : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddAnAdvertBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_add_an_advert,container,false
        )
        val toolbar:Toolbar = requireActivity().findViewById(R.id.toolbar)
        toolbar.menu.clear()
        val buttonforspareparts = binding.imageView48
        binding.imageView47.setColorFilter(ContextCompat.getColor(requireContext(), R.color.qsnyellow),
            PorterDuff.Mode.SRC_IN);
        buttonforspareparts.setOnClickListener{
            findNavController().navigate(R.id.addAnAdvert1)
        }
        val buttonforcar = binding.imageView47
        //buttonforcar.setBackgroundResource(R.drawable.bg_layout_for_clickedadverticon)

         fortoolbar()

        return binding.root
    }
    private fun fortoolbar() {
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Add Advert"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().toolbar.equalizer.isVisible = false
        requireActivity().bottomNavigationViewmain.isVisible = true
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