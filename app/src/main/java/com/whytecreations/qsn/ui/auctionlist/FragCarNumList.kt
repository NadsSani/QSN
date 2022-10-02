package com.whytecreations.qsn.ui.auctionlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentFragCarNumListBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import com.whytecreations.qsn.ui.auctionlistadapter.AuctionAdapter


class FragCarNumList : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding :FragmentFragCarNumListBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_frag_car_num_list,container,false)
        val ls=ArrayList<AuctionDataclass>()
        arguments?.takeIf { it.containsKey(Companion.ARG_OBJECT) }?.apply {

            val text = getInt(Companion.ARG_OBJECT).toString()
        }
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))


        val recyclerbinding = binding.recyclecarnumlist
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = AuctionAdapter(requireActivity(),ls)
            hasFixedSize()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(Companion.ARG_OBJECT) }?.apply {

         val text = getInt(Companion.ARG_OBJECT).toString()
        }
    }

    companion object {
        private const val ARG_OBJECT = "object"
    }

}