package com.whytecreations.qsn.ui.auctionlist

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentAuctionListsBinding
import com.whytecreations.qsn.ui.auctionlistadapter.AuctionAdapter
import com.whytecreations.qsn.ui.auctionlistadapter.CarListAdapter
import com.whytecreations.qsn.ui.auctionlistadapter.MyBidsAdapter
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.whytecreations.qsn.datamodels.BaseModel
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class AuctionLists : Fragment() {
    val ls=ArrayList<AuctionDataclass>()
    private val homeViewModel: BaseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentAuctionListsBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_auction_lists,container,false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel

       fortoolbar()
        binding.carnumberbutton.setOnClickListener{
         carnumberbuttonselect(homeViewModel,binding)

      }
      binding.phonenumberbutton.setOnClickListener{
         phonenumberbuttonselect(homeViewModel,binding)

      }



        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))


        val recyclerbinding = binding.auctionlisting
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = AuctionAdapter(requireActivity(),ls)
            hasFixedSize()
        }
        homeViewModel.selecteditem.observe(viewLifecycleOwner){
            when(it.name.toString()){
                "Private" -> privater(recyclerbinding,it)
                "Commercial" ->  commercial(recyclerbinding,it)
                "Bikes Qatar" ->  bikesqatar(recyclerbinding,it)
                "oreedo" ->  oreedo(recyclerbinding,it)
                "vodafone" ->  vodafone(recyclerbinding,it)
                "Land Line" ->  landline(recyclerbinding,it)
            }


        }


       homeViewModel.fillbanner()
        PagerSnapHelper().attachToRecyclerView(binding.swiperecycle)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.indicator.attachToRecyclerView(binding.swiperecycle)
        }, 2000)
        requireActivity().toolbar.setNavigationOnClickListener {
            toggle()
        }

        return binding.root

    }

    private fun phonenumberbuttonselect(homeViewModel: BaseViewModel,binding: FragmentAuctionListsBinding) {
        binding.imageView13.setColorFilter(ContextCompat.getColor(requireContext(), R.color.qsnyellow), PorterDuff.Mode.SRC_IN);
        binding.imageView14.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorgrey), PorterDuff.Mode.SRC_IN);
        binding.textView19.setTextColor(ContextCompat.getColor(requireContext(),R.color.colorgrey))
        binding.textView17.setTextColor(ContextCompat.getColor(requireContext(),R.color.qsnyellow))
        binding.phonenumberbutton.setBackgroundResource(R.drawable.selectbgforauction)
        binding.carnumberbutton.setBackgroundResource(R.drawable.cardviewboarder)
        homeViewModel.phoneselected()
    }

    private fun carnumberbuttonselect(homeViewModel: BaseViewModel,binding: FragmentAuctionListsBinding) {
        binding.imageView14.setColorFilter(ContextCompat.getColor(requireContext(), R.color.qsnyellow), PorterDuff.Mode.SRC_IN);
        binding.imageView13.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorgrey), PorterDuff.Mode.SRC_IN);
        binding.textView19.setTextColor(ContextCompat.getColor(requireContext(),R.color.qsnyellow))
        binding.textView17.setTextColor(ContextCompat.getColor(requireContext(),R.color.colorgrey))
        binding.carnumberbutton.setBackgroundResource(R.drawable.selectbgforauction)
        binding.phonenumberbutton.setBackgroundResource(R.drawable.cardviewboarder)
        homeViewModel.carselected()
    }


    private fun privater(recycler:RecyclerView,items:BaseModel){
//        val divider = DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)
//        ContextCompat.getDrawable(requireActivity(), R.drawable.dividerrec)?.let {
//            divider.setDrawable(
//                it
//            )
//        }
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = CarListAdapter(requireActivity(),ls)
            hasFixedSize()
            //addItemDecoration(divider)
        }

    }

    private fun commercial(recycler: RecyclerView,items: BaseModel){
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = AuctionAdapter(requireActivity(),ls)
            hasFixedSize()

        }

    }

    private fun bikesqatar(recycler: RecyclerView,items:BaseModel){
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MyBidsAdapter(requireActivity(),ls)
            hasFixedSize()

        }
    }

    private fun oreedo(recycler: RecyclerView,items:BaseModel){
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MyBidsAdapter(requireActivity(),ls)
            hasFixedSize()

        }

    }
    private fun vodafone(recycler: RecyclerView,items:BaseModel){
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MyBidsAdapter(requireActivity(),ls)
            hasFixedSize()
        }
    }

    private fun landline(recycler: RecyclerView,items:BaseModel){
        recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MyBidsAdapter(requireActivity(),ls)
            hasFixedSize()

        }
    }

    private fun toggle() {
        if (requireActivity().drawerLayout.isDrawerVisible(GravityCompat.START)) {
            requireActivity().drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().drawerLayout.openDrawer(GravityCompat.START)
        }
    }
    private fun fortoolbar() {
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().toolbar.equalizer.isVisible = false
        requireActivity().bottomNavigationViewmain.isVisible = true
         requireActivity().heading.text = "Auction Lists"
    }


}