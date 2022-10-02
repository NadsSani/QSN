package com.whytecreations.qsn.ui.auctionlistadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.RentACarlistBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass

class RentACarAdapter (context: Context, ls:ArrayList<AuctionDataclass>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val context: Context = context
    var ls:ArrayList<AuctionDataclass> = ls

    companion object{
        const val item_viewtype = 1
        const val item_viewtype2 = 2
    }

    class ViewHolder(view: RentACarlistBinding) : RecyclerView.ViewHolder(view.root){
        val cardView: CardView
        init {
            cardView = view.root.findViewById(R.id.carlistcardid)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
//            .inflate(R.layout.cards_for_list, parent, false)
        val rentACarlistBinding = RentACarlistBinding.inflate(view,parent,false)


        return ViewHolder(rentACarlistBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        holder.cardView.setOnClickListener{
            it.findNavController().navigate(R.id.rentACarDetails)
        }


    }

    override fun getItemCount(): Int {
        return ls.size
    }
}