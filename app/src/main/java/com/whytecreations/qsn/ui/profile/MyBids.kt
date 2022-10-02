package com.whytecreations.qsn.ui.profile

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentMyBidsBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import com.whytecreations.qsn.ui.auctionlistadapter.MyBidsAdapter
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class MyBids : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val baseViewModel: BaseViewModel by navGraphViewModels(R.id.dash_board_navigation)
    { defaultViewModelProviderFactory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMyBidsBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_my_bids,container,false
        )
//        val buttonfilter = binding.textFieldwonspinner
//          buttonfilter.setOnClickListener {
//                  v: View ->
//              showMenu(v, R.menu.basemenu)
//          }
        fortoolbar()
        val ls=ArrayList<AuctionDataclass>()
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        val recyclerbinding = binding.recyclemybids
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = MyBidsAdapter(requireActivity(),ls)
            hasFixedSize()
        }
        requireActivity().toolbar.setNavigationOnClickListener {
            toggle()
        }
       binding.textFieldcompleted.setOnClickListener {
           binding.textFieldcompleted.setBackgroundResource(R.drawable.bgfor_tablayout_yellow)
           binding.textFieldcurrent.setBackgroundResource(R.drawable.bgfor_tablayout)
           binding.textFieldcurrent.setTextColor(ContextCompat.getColor(requireContext()
               ,R.color.colorgrey))
           binding.textFieldcompleted.setTextColor(ContextCompat.getColor(requireContext()
               ,R.color.qsnyellow))
       }
       binding.textFieldcurrent.setOnClickListener {
           binding.textFieldcompleted.setBackgroundResource(R.drawable.bgfor_tablayout)
           binding.textFieldcurrent.setBackgroundResource(R.drawable.bgfor_tablayout_yellow)
           binding.textFieldcurrent.setTextColor(ContextCompat.getColor(requireContext()
               ,R.color.qsnyellow))
           binding.textFieldcompleted.setTextColor(ContextCompat.getColor(requireContext()
               ,R.color.colorgrey))
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
        requireActivity().heading.text = "My Bids"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.equalizer.isVisible = false

    }
//    private fun showMenu(v: View, @MenuRes menuRes: Int) {
//        val popup = PopupMenu(requireContext(), v)
//        popup.menuInflater.inflate(menuRes, popup.menu)
//
////        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
////            // Respond to menu item click.
////        }
//        popup.setOnDismissListener {
//            // Respond to popup being dismissed.
//        }
//        // Show the popup menu.
//        popup.show()
//    }

}