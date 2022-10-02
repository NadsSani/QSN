package com.whytecreations.qsn.ui.carlist.spareparts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentSparePartsBinding
import com.whytecreations.qsn.databinding.FragmentSparePartsFilterBinding
import com.whytecreations.qsn.ui.carlist.rentacar.RentACarFilter


class SparePartsFilter : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreenDialog_NoStatusBar)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentSparePartsFilterBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_spare_parts_filter,container,false)
        binding.closebtnsparefilter.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
    companion object {
        fun display(fragmentManager: FragmentManager): SparePartsFilter {

            val dialog = SparePartsFilter()
//            var args = Bundle()
//            args.putString("post_id", postId)
//            dialog.arguments = args
//            Log.e("postid",postId)
            dialog.show(fragmentManager, "details_dialog")

            return dialog
        }
    }

}