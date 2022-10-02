package com.whytecreations.qsn.ui.home

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentDashBoardBinding
import com.whytecreations.qsn.viewmodels.BaseViewModel
import com.whytecreations.qsn.viewmodels.HomeActViewModel
import com.whytecreations.qsn.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class DashBoard : Fragment() {
    private val activityViewModel: HomeActViewModel by viewModels { ViewModelFactory.getInstance() }
    private val homeViewModel: BaseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentDashBoardBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_dash_board,container,false)
           binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel
        initialized(binding)
        requireActivity().toolbar.setNavigationOnClickListener {
            toggle()
        }
        homeViewModel.fillbanner()
        PagerSnapHelper().attachToRecyclerView(binding.swiperecycle)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.indicator.attachToRecyclerView(binding.swiperecycle)
        }, 2000)
        return binding.root
    }

    private fun toggle() {
        if (requireActivity().drawerLayout.isDrawerVisible(GravityCompat.START)) {
            requireActivity().drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().drawerLayout.openDrawer(GravityCompat.START)
        }
    }


    fun initialized(binding: FragmentDashBoardBinding){
        requireActivity().toolbar.isVisible = true
       requireActivity().toolbar.heading.text = "QSN"
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().myButton4.isVisible = true
        requireActivity().badge_notification_4.isVisible= true
        requireActivity().toolbar.equalizer.isVisible = false
        val button = binding.auctionbutton
        button.setOnClickListener {
            findNavController().navigate(R.id.auctionLists)
        }
        val carslistbutton = binding.carslistbutton
        carslistbutton.setOnClickListener{
            findNavController().navigate(R.id.carLists)
        }
        val rentacarlist = binding.rentacarlistes
        rentacarlist.setOnClickListener{
            val actions = DashBoardDirections.actionDashBoardToCarLists(chooser="rentacarlists")
            val bundle = bundleOf("chooser" to "rentacarlists")
            it.findNavController().navigate(R.id.carLists,bundle)
        }
        val dealerslist= binding.dealerslistes
        dealerslist.setOnClickListener{
            val actions = DashBoardDirections.actionDashBoardToCarLists(chooser ="dealerslist")

            val bundle = bundleOf("chooser" to "dealerslist")
            it.findNavController().navigate(R.id.carLists,bundle)
        }
        val garagerslist = binding.garagers
        garagerslist.setOnClickListener{
            val actions = DashBoardDirections.actionDashBoardToCarLists(chooser="garagelist")
            val bundle = bundleOf("chooser" to "garagelist")
            it.findNavController().navigate(R.id.carLists,bundle)
        }
        val sparepartses = binding.sparepartses
        sparepartses.setOnClickListener{
            val bundle = bundleOf("chooser" to "sparepartslist")
            it.findNavController().navigate(R.id.carLists,bundle)
        }
    }

}