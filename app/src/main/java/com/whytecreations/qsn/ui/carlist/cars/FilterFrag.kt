package com.whytecreations.qsn.ui.carlist.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.whytecreations.qsn.databinding.FragmentFilterBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.whytecreations.qsn.R


class FilterFrag :  DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog_NoStatusBar)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding:FragmentFilterBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_filter,container,false)

        val selectcity  = binding.textField
//        selectcity.setOnClickListener{
//            findNavController().navigate(R.id.selectCity)
//        }
        binding.closebutton.setOnClickListener {
            dismiss()
        }
        fortoolbar()
        return binding.root
    }

    private fun fortoolbar() {
//        val navBar: CurvedBottomNavigationView = requireActivity().findViewById(com.whytecreations.qsn.R.id.bottomNavigationViewmain)
//        navBar.isVisible = false
//        requireActivity().toolbar.equalizer.isVisible = false
//        requireActivity().toolbar.myButton4.isVisible = false
//        requireActivity()
    }
    companion object {
        fun display(fragmentManager: FragmentManager): FilterFrag {

            val dialog = FilterFrag()
//            var args = Bundle()
//            args.putString("post_id", postId)
//            dialog.arguments = args
//            Log.e("postid",postId)
            dialog.show(fragmentManager, "details_dialog")

            return dialog
        }
    }

}