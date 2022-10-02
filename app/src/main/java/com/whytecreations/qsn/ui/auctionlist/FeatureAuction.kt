package com.whytecreations.qsn.ui.auctionlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentFeatureAuctionBinding
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class FeatureAuction : Fragment() {
  lateinit var binding:FragmentFeatureAuctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_feature_auction,container,false)
        binding.lifecycleOwner = viewLifecycleOwner

fortoolbar()

        return binding.root

    }

    private fun fortoolbar() {
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Feature Now"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.equalizer.isVisible = false
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

    }
}