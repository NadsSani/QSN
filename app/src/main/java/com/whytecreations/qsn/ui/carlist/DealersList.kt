package com.whytecreations.qsn.ui.carlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentDealersListBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import com.whytecreations.qsn.ui.auctionlistadapter.DealersAdapter


class DealersList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:FragmentDealersListBinding = DataBindingUtil.inflate(inflater
            ,R.layout.fragment_dealers_list,container,false)
        val ls=ArrayList<AuctionDataclass>()
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        val recyclerbinding = binding.recycledealer
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = DealersAdapter(requireActivity(),ls)
            hasFixedSize()
        }

        return binding.root
    }


}