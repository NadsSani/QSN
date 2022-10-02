package com.whytecreations.qsn.ui.carlist.cars

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentCarDetailsPageBinding
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class CarDetailsPage : Fragment() {
    private val homeViewModel: BaseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCarDetailsPageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_car_details_page,container,false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel




        fortoolbar()

        homeViewModel.fillbanner()
        PagerSnapHelper().attachToRecyclerView(binding.pager)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.indicator.attachToRecyclerView(binding.pager)
        }, 2000)

        return binding.root
        }

    private fun fortoolbar() {
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().heading.text ="Car Details Page"
        requireActivity().badge_notification_4.isVisible = false
        requireActivity().myButton4.isVisible = false
        requireActivity().equalizer.isVisible  = false
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }


}