package com.whytecreations.qsn.ui.auctionlist

import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.EditText
import android.widget.PopupWindow
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.whytecreations.qsn.databinding.FragmentAuctionListCarNumberBinding


import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentAuctionListsBinding
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*
import java.text.SimpleDateFormat
import java.util.*


class AuctionListCarNumber : Fragment() {
    private val homeViewModel: BaseViewModel by viewModels()

    private lateinit var binding:FragmentAuctionListCarNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            com.whytecreations.qsn.R.layout.fragment_auction_list_car_number,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel
        binding.auctiondetailscarnobtn.setOnClickListener{
            carnumberbuttonselect(homeViewModel,binding)
        }
        binding.auctiondetailsphonnobtn.setOnClickListener{
            phonenumberbuttonselect(homeViewModel,binding)
        }
       forToolBar()
       // binding.auctiondetailscarnumberdate.transformIntoDatePicker(requireContext(), "MM/dd/yyyy", Date())
        binding.auctiondetailscarnumberdate.setOnClickListener {
            binding.ivdemocard.isVisible = true
        }
        binding.auctionlistcarnumbercalendar.setOnDateChangeListener(object :
            CalendarView.OnDateChangeListener {
            override fun onSelectedDayChange(
                view: CalendarView,
                year: Int,
                month: Int,
                dayOfMonth: Int
            ) {

                binding.auctiondetailscarnumberdate
                    .setText(dayOfMonth.toString() + "/"+month.toString()+"/"+year.toString())
            }
        })






        binding.auctioncarnumberproceedbtn.setOnClickListener{
            val builder: AlertDialog.Builder? = activity?.let {
                AlertDialog.Builder(it)
            }
            val mView = View.inflate(requireActivity(), R.layout.auctionlistpopup, null)
            builder?.setView(mView)

            val dialog: AlertDialog? = builder?.create()
            dialog?.show()

            dialog?.window?.setLayout(1100,1500)
            dialog?.window?.setGravity(Gravity.FILL_HORIZONTAL);
            dialog?.window?.setGravity(Gravity.BOTTOM);

        }

        return binding.root
    }

    private fun forToolBar() {
        requireActivity().heading.text = "Auction Details"
        requireActivity().badge_notification_4.isVisible = false
        requireActivity().myButton4.isVisible = false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.equalizer.isVisible = false
    }

    override fun onStart() {
        super.onStart()
       forToolBar()
    }
    fun EditText.transformIntoDatePicker(context: Context,
                                         format: String, maxDate: Date? = null) {
        isFocusableInTouchMode = false
        isClickable = true
        isFocusable = false

        val myCalendar = Calendar.getInstance()
        val datePickerOnDataSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, monthOfYear)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val sdf = SimpleDateFormat(format, Locale.UK)
                setText(sdf.format(myCalendar.time))

            }

        setOnClickListener {
            DatePickerDialog.newInstance(datePickerOnDataSetListener, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).run {

                show(this@AuctionListCarNumber.childFragmentManager,"Datepickerdialog")
            }

        }
    }
    private fun phonenumberbuttonselect(homeViewModel: BaseViewModel,binding: FragmentAuctionListCarNumberBinding) {
        binding.imageView13.setColorFilter(ContextCompat.getColor(requireContext(), R.color.qsnyellow), PorterDuff.Mode.SRC_IN);
        binding.imageView14.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorgrey), PorterDuff.Mode.SRC_IN);
        binding.textView19.setTextColor(ContextCompat.getColor(requireContext(),R.color.colorgrey))
        binding.textView17.setTextColor(ContextCompat.getColor(requireContext(),R.color.qsnyellow))
        binding.auctiondetailsphonnobtn.setBackgroundResource(R.drawable.selectbgforauction)
        binding.auctiondetailscarnobtn.setBackgroundResource(R.drawable.cardviewboarder)
        homeViewModel.phoneselected()
    }

    private fun carnumberbuttonselect(homeViewModel: BaseViewModel,binding: FragmentAuctionListCarNumberBinding) {
        binding.imageView14.setColorFilter(ContextCompat.getColor(requireContext(), R.color.qsnyellow), PorterDuff.Mode.SRC_IN);
        binding.imageView13.setColorFilter(ContextCompat.getColor(requireContext(), R.color.colorgrey), PorterDuff.Mode.SRC_IN);
        binding.textView19.setTextColor(ContextCompat.getColor(requireContext(),R.color.qsnyellow))
        binding.textView17.setTextColor(ContextCompat.getColor(requireContext(),R.color.colorgrey))
        binding.auctiondetailscarnobtn.setBackgroundResource(R.drawable.selectbgforauction)
        binding.auctiondetailsphonnobtn.setBackgroundResource(R.drawable.cardviewboarder)
        homeViewModel.carselected()
    }
}


