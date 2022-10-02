package com.whytecreations.qsn.ui.auctionlistadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.CardsDealerBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass

class DealersAdapter(context: Context,ls:ArrayList<AuctionDataclass>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val context: Context = context
    var ls:ArrayList<AuctionDataclass> = ls

    companion object{
        const val item_viewtype = 1
        const val item_viewtype2 = 2
    }

    class ViewHolder(view: CardsDealerBinding) : RecyclerView.ViewHolder(view.root){
        val cardView: CardView = view.root.findViewById(R.id.cardsdealerid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
//            .inflate(R.layout.cards_for_list, parent, false)
        val cardsForListBinding = CardsDealerBinding.inflate(view,parent,false)


        return ViewHolder(cardsForListBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        holder.cardView.setOnClickListener{
            it.findNavController().navigate(R.id.carDealersDetails)
        }

    }

    override fun getItemCount(): Int {
        return ls.size
    }
}