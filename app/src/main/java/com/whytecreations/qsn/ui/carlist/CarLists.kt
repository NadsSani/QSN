package com.whytecreations.qsn.ui.carlist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.whytecreations.qsn.R
import com.whytecreations.qsn.databinding.FragmentCarListsBinding
import com.whytecreations.qsn.ui.auctionlist.auctiondataclass.AuctionDataclass
import android.widget.ArrayAdapter
import androidx.appcompat.widget.ListPopupWindow
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.GravityCompat


import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.whytecreations.qsn.ui.auctionlistadapter.*
import com.whytecreations.qsn.ui.carlist.cars.FilterFrag
import com.whytecreations.qsn.ui.carlist.garage.GarageFilter
import com.whytecreations.qsn.ui.carlist.rentacar.RentACarFilter
import com.whytecreations.qsn.ui.carlist.spareparts.SparePartsFilter
import com.whytecreations.qsn.viewmodels.BaseViewModel
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.activity_dash_board.view.*


class CarLists : Fragment() {
    val ls=ArrayList<AuctionDataclass>()
    private val homeViewModel: BaseViewModel by viewModels()
    val args: CarListsArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:FragmentCarListsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_car_lists,container,false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel

        //dummy data to remove after geting apis

        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))
        ls.add(AuctionDataclass(1,"nadeem"))
        ls.add(AuctionDataclass(2,"nadeem"))



//main recyclerview
        val recyclerbinding = binding.carlists
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = CarListAdapter(requireActivity(),ls)
            hasFixedSize()
        }
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        initializebutton(binding,recyclerbinding)




        Log.e("method",arguments?.getString("chooser").toString())
        when(arguments?.getString("chooser")){
            "rentacarlist" -> rentACarMet(binding,recyclerbinding)
            "dealerslist" -> dealersListMet(binding,recyclerbinding)
            "garagelist" -> garageMet(binding,recyclerbinding)
            "sparepartslist"->sparePartsMeth(binding,recyclerbinding)
            else -> carsListMet(binding,recyclerbinding)


        }
        //drop down menu
        registercontext(binding)


        //tool bar initializer
        fortoolbar()

        return binding.root
    }

    private fun registercontext(binding: FragmentCarListsBinding) {
        val spinner = binding.spinner
        val listPopupWindow = ListPopupWindow(requireContext()!!, null, R.attr.listPopupWindowStyle)
        listPopupWindow.anchorView = spinner
        val items = listOf("Relevance", "Recently Added", "Most Viewed","Price(low to high)","Price(high to low)")
        val adapter = ArrayAdapter(requireContext(), R.layout.carlist_popup_menu, items)
        listPopupWindow.setAdapter(adapter)
        listPopupWindow.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                    listPopupWindow.dismiss()
        }

       spinner.setOnClickListener { v: View? ->

           if (listPopupWindow.isShowing){

               listPopupWindow.dismiss()

           }
           else{

               listPopupWindow.show()
           }
       }

    }

    private fun registercontextrentacar(binding: FragmentCarListsBinding) {
        val spinner = binding.spinner
        val listPopupWindow = ListPopupWindow(requireContext()!!, null, R.attr.listPopupWindowStyle)
        listPopupWindow.anchorView = spinner
        val items = listOf("Relevance", "Recently Added", "Most Viewed")
        val adapter = ArrayAdapter(requireContext(), R.layout.carlist_popup_menu, items)
        listPopupWindow.setAdapter(adapter)
        listPopupWindow.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            listPopupWindow.dismiss()
        }

        spinner.setOnClickListener { v: View? ->

            if (listPopupWindow.isShowing){

                listPopupWindow.dismiss()

            }
            else{

                listPopupWindow.show()
            }
        }

    }




    private fun fortoolbar() {
         requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Cars"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().toolbar.equalizer.isVisible = true
        requireActivity().bottomNavigationViewmain.isVisible = true
          requireActivity().toolbar.equalizer.setOnClickListener {
              FilterFrag.display(childFragmentManager)
          }
    }

    fun initializebutton(binding:FragmentCarListsBinding,recyclerView: RecyclerView){

        binding.carslistsbtn.setOnClickListener{ carsListMet(binding,recyclerView) }
        binding.dealersListBtn.setOnClickListener { dealersListMet(binding,recyclerView) }
        binding.garageBtn.setOnClickListener { garageMet(binding,recyclerView) }
        binding.rentACarBtn.setOnClickListener { rentACarMet(binding,recyclerView) }
        binding.sparePartsBtn.setOnClickListener { sparePartsMeth(binding,recyclerView) }

    }

    fun carsListMet(binding: FragmentCarListsBinding
                    ,recyclerbinding: RecyclerView){
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Cars"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.navigationicon)
        requireActivity().toolbar.equalizer.isVisible = true
        registercontext(binding)
        requireActivity().toolbar.equalizer.setOnClickListener {
            FilterFrag.display(childFragmentManager)
        }
        requireActivity().toolbar.setNavigationOnClickListener {
           toggle()

        }
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = CarListAdapter(requireActivity(),ls)
            hasFixedSize()
        }

        binding.spinner.isVisible = true
        binding.searchview.isVisible = false
       // requireActivity().toolbar.setNavigationIcon(R.drawable.path_3698)
    }
    fun dealersListMet(binding: FragmentCarListsBinding
                       ,recyclerbinding: RecyclerView){
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Dealers"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.equalizer.isVisible = false
        requireActivity().toolbar.setNavigationOnClickListener {
           carsListMet(binding,recyclerbinding)
        }

        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = DealersAdapter(requireActivity(),ls)
            hasFixedSize()
        }


        requireActivity().toolbar.setTitle("Dealers")
        binding.spinner.isVisible = false
        binding.searchview.isVisible = true

    }
    fun garageMet(binding: FragmentCarListsBinding
                  ,recyclerbinding: RecyclerView){
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Garage"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.equalizer.isVisible = true
        //temporary solution for dropdown menu
        registercontextrentacar(binding)
        requireActivity().toolbar.setNavigationOnClickListener {
            carsListMet(binding,recyclerbinding)
        }
        requireActivity().toolbar.equalizer.setOnClickListener {
            GarageFilter.display(childFragmentManager)
        }
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = GarageAdapter(requireActivity(),ls)
            hasFixedSize()
        }
        binding.spinner.isVisible = true
        binding.searchview.isVisible = true

    }
    fun rentACarMet(binding: FragmentCarListsBinding
                    ,recyclerbinding: RecyclerView){
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Rent a Car"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.equalizer.isVisible = true
        registercontextrentacar(binding)
        requireActivity().toolbar.equalizer.setOnClickListener {
            RentACarFilter.display(childFragmentManager)
        }
        requireActivity().toolbar.setNavigationOnClickListener {
            carsListMet(binding,recyclerbinding)
        }
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = RentACarAdapter(requireActivity(),ls)
            hasFixedSize()
        }
        binding.spinner.isVisible = true
        binding.searchview.isVisible = false
      // change spinner values
    }
    fun sparePartsMeth(binding: FragmentCarListsBinding
                       ,recyclerbinding: RecyclerView){
        requireActivity().toolbar.isVisible = true
        requireActivity().heading.text = "Spare Parts"
        requireActivity().myButton4.isVisible =false
        requireActivity().badge_notification_4.isVisible= false
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.equalizer.isVisible = true

        requireActivity().toolbar.setNavigationOnClickListener {
            carsListMet(binding,recyclerbinding)
        }
        requireActivity().toolbar.equalizer.setOnClickListener {
           SparePartsFilter.display(childFragmentManager)
        }
        recyclerbinding.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = SparePartsAdapter(requireActivity(),ls)
            hasFixedSize()
        }
        registercontext(binding)
        binding.spinner.isVisible = true
        binding.searchview.isVisible = false
    }

    private fun toggle() {
        if (requireActivity().drawerLayout.isDrawerVisible(GravityCompat.START)) {
            requireActivity().drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().drawerLayout.openDrawer(GravityCompat.START)
        }
    }























    //    val spinner = binding.spinner

//        ArrayAdapter.createFromResource(
//            requireActivity(),
//            R.array.relevance_array,
//            R.layout.textviewforcarlistspinner
//        ).also { adapter ->
//            adapter.setDropDownViewResource(R.layout.checkboxforrelevance)
//            spinner.adapter = adapter
//        }
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
//                if (p2==0){
//                }
//                else{
//                }
//            }
//        }
}