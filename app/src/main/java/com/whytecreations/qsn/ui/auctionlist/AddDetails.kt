package com.whytecreations.qsn.ui.auctionlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentAddDetailsBinding
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*
import java.text.SimpleDateFormat
import java.util.*


class AddDetails : Fragment() {
    private val homeViewModel: BaseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val binding:FragmentAddDetailsBinding = DataBindingUtil.inflate(inflater,
           R.layout.fragment_add_details,container,false)
        binding.homeViewModel = homeViewModel
        binding.auctiondetailscarnobtn.setOnClickListener{
            homeViewModel.carselected()
        }
        binding.auctiondetailsphonnobtn.setOnClickListener{
            homeViewModel.phoneselected()
        }
       // binding.auctiondetailscarnumberdate.transformIntoDatePicker(requireContext(), "MM/dd/yyyy", Date())
        binding.auctiondetailscarnumberdate.setOnClickListener{
            binding.idcalender.isVisible = true

        }

        binding.auctionlistphonenumbercalendar.setOnDateChangeListener(object :
            OnDateChangeListener {
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


         forToolBar()
        return binding.root

    }

    private fun forToolBar() {
        requireActivity().heading.text = "Auction CarNumber"
        requireActivity().badge_notification_4.isVisible = false
        requireActivity().myButton4.isVisible = false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().bottomNavigationViewmain.isVisible = true
        requireActivity().toolbar.equalizer.isVisible = false
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

                show(this@AddDetails.childFragmentManager,"Datepickerdialog")
            }

        }
    }


}