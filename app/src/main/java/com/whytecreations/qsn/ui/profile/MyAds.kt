package com.whytecreations.qsn.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentMyAdsBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import com.whytecreations.qsn.ui.auctionlistadapter.MyAdsAdapter
import com.whytecreations.qsn.ui.auctionlistadapter.MyAdsOngoinAdapter
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*

class MyAds : Fragment() {
    private var auctionorlisted:String = "auction"
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMyAdsBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_my_ads,container,false
        )
//        val buttonfilter = binding.textFieldwonspinner


        val ls=ArrayList<AuctionDataclass>()
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        val recyclerbinding = binding.recyclemyads
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MyAdsAdapter(requireActivity(),ls)
            hasFixedSize()
        }
          binding.radioButton5.setOnClickListener {

              recyclerbinding.apply {
                  layoutManager = LinearLayoutManager(requireActivity())
                  adapter = MyAdsAdapter(requireActivity(),ls)
                  hasFixedSize()
              }

          }

        binding.radioButton6.setOnClickListener{
            recyclerbinding.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = MyAdsOngoinAdapter(requireActivity(),ls)
                hasFixedSize()
            }
        }


//        button = Button(requireActivity())
//        button.setBackgroundResource(R.drawable.curved_bg_signin)
//        button.text = "Feature Now"
//        button.setPadding(20,20,20,20)
//        button.setId(R.id.featurebutton)
//        button.scaleX  = .9F
//        button.scaleY = .7F
//        button.textSize = 12F
//        val toollayout:Toolbar.LayoutParams = Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT,
//            Toolbar.LayoutParams.WRAP_CONTENT)
//        toollayout.gravity = Gravity.END
//
//
//        button.layoutParams = toollayout
       // requireActivity().toolbar.addView(button)

        requireActivity().featurebtn.setOnClickListener {
            if (auctionorlisted == "auction") {
                findNavController().navigate(R.id.featureAuction)
            }
            else{
                findNavController().navigate(R.id.featureListed)
            }
        }





        binding.auctionbtn.setOnClickListener {
            auctionorlisted = "auction"
            binding.auctionbtn.setTextColor(
                ContextCompat.getColor(requireContext()
                ,R.color.qsnyellow))
            binding.auctionbtn.setBackgroundResource(R.drawable.bgfor_tablayout_yellow)
            binding.lstdbtn.setTextColor(ContextCompat.getColor(requireContext()
                ,R.color.colorgrey))
            binding.lstdbtn.setBackgroundResource(R.drawable.bgfor_tablayout)
        }
        binding.lstdbtn.setOnClickListener {
            auctionorlisted = "listed"
            Log.e("Clicked","clinch")
            binding.lstdbtn.setTextColor(ContextCompat.getColor(requireContext()
                ,R.color.qsnyellow))
            binding.lstdbtn.setBackgroundResource(R.drawable.bgfor_tablayout_yellow)
            binding.auctionbtn.setTextColor(ContextCompat.getColor(requireContext()
                ,R.color.colorgrey))
            binding.auctionbtn.setBackgroundResource(R.drawable.bgfor_tablayout)
        }


      fortoolbar()
        requireActivity().toolbar.setNavigationOnClickListener {
            toggle()
        }
        return binding.root
    }

    private fun toggle() {
        if (requireActivity().drawerLayout.isDrawerVisible(GravityCompat.START)) {
            requireActivity().drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().drawerLayout.openDrawer(GravityCompat.START)
        }
    }


    private fun fortoolbar() {

        requireActivity().toolbar.isVisible = true
        requireActivity().featurebtn.isVisible = true
        requireActivity().heading.text = "My Ads"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.equalizer.isVisible = false

    }
    private fun listdbtnaction(){

    }
    private fun auctionbtnaction(){

    }
    override fun onStop() {
        requireActivity().featurebtn.isVisible = false
        //requireActivity().toolbar.removeView(button)
        super.onStop()
    }
}