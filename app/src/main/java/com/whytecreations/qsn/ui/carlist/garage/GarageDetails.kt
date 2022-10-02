package com.whytecreations.qsn.ui.carlist.garage

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentGarageBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class GarageDetails : Fragment() {

    private val homeViewModel: BaseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding :FragmentGarageBinding = DataBindingUtil
                .inflate(inflater,R.layout.fragment_garage,container,false)
        val ls=ArrayList<AuctionDataclass>()
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel
         requireActivity().toolbar.setTitle("Garage Detail")
        homeViewModel.fillbanner()
        PagerSnapHelper().attachToRecyclerView(binding.pager)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.indicator.attachToRecyclerView(binding.pager)
        }, 2000)

fortoolbar()
        return binding.root


    }

    private fun fortoolbar() {
        requireActivity().toolbar.isVisible = true
        requireActivity().toolbar.setTitle("Garage Detail")
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