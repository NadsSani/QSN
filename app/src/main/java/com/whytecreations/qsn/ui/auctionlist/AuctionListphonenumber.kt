package com.whytecreations.qsn.ui.auctionlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentAuctionListphonenumberBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_dash_board.*


class AuctionListphonenumber : Fragment() {
    private lateinit var demoCollectionAdapter: DemoCollection2Adapter
    private lateinit var viewPager: ViewPager2
    private lateinit var binding: FragmentAuctionListphonenumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_auction_listphonenumber,container,false)
        demoCollectionAdapter = DemoCollection2Adapter(this)
        viewPager = binding.pagerforphonenumber
        viewPager.adapter = demoCollectionAdapter
        val tabLayout = binding.tabforphonenumber

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if(position == 0){
                tab.text = "oreodoo"
            }else if(position == 1){
                tab.icon.apply { R.drawable.vodafone }
            }
            else{
                tab.text = "LandLine"
            }
        }.attach()

         forToolBar()


        return binding.root
    }
    private fun forToolBar() {
        requireActivity().heading.text ="Auction Car Number"
        requireActivity().badge_notification_4.isVisible = false
        requireActivity().myButton4.isVisible = false
        requireActivity().equalizer.isVisible  = false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
    }

}
private const val ARG_OBJECT = "object"
class DemoCollection2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = FragCarNumList()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}