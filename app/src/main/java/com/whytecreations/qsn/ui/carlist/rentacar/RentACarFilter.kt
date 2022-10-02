package com.whytecreations.qsn.ui.carlist.rentacar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentRentACarFilterBinding




class RentACarFilter : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog_NoStatusBar)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentRentACarFilterBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_rent_a_car_filter,container,false)
        binding.closebtmrentfilter.setOnClickListener {
            dismiss()
        }
       return binding.root
    }
    companion object {
        fun display(fragmentManager: FragmentManager): RentACarFilter {

            val dialog = RentACarFilter()
//            var args = Bundle()
//            args.putString("post_id", postId)
//            dialog.arguments = args
//            Log.e("postid",postId)
            dialog.show(fragmentManager, "details_dialog")

            return dialog
        }
    }

}