package com.whytecreations.qsn.ui.auctionlistadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whytecreations.qsn.R
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass

class MyAdsAdapter(context: Context, ls:ArrayList<AuctionDataclass>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val context: Context = context
    var ls:ArrayList<AuctionDataclass> = ls
    companion object{
        const val item_viewtype = 1
        const val item_viewtype2 = 2
    }

    override fun getItemViewType(position: Int): Int {
        return ls[position].itemtype
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == item_viewtype){
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.myadscardview,parent,false))
        }else{
            return ViewHolder2(
                LayoutInflater.from(context).inflate(
                    R.layout.myadscardview2,parent,false))

        }
    }



    override fun getItemCount(): Int {
        return ls.size
    }
    class ViewHolder(View: View):
        RecyclerView.ViewHolder(View){

    }
    class ViewHolder2(view: View):
        RecyclerView.ViewHolder(view){

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(ls[position].itemtype == item_viewtype){
            (holder as ViewHolder)
        }
        else{
            (holder as ViewHolder2)
        }
    }
}