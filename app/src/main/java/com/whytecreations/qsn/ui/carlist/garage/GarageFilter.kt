package com.whytecreations.qsn.ui.carlist.garage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentGarageFilterBinding
import com.whytecreations.qsn.ui.carlist.rentacar.RentACarFilter


class GarageFilter : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog_NoStatusBar)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding:FragmentGarageFilterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_garage_filter,container,false)
        binding.closebtnlocationfilter.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    companion object {
        fun display(fragmentManager: FragmentManager): GarageFilter {

            val dialog = GarageFilter()
//            var args = Bundle()
//            args.putString("post_id", postId)
//            dialog.arguments = args
//            Log.e("postid",postId)
            dialog.show(fragmentManager, "details_dialog")

            return dialog
        }
    }

}