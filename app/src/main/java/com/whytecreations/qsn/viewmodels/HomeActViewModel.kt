package com.whytecreations.qsn.viewmodels

import androidx.lifecycle.MutableLiveData

class HomeActViewModel :BaseViewModel() {



    val title= MutableLiveData<String>()
    val showCategoryList= MutableLiveData<Boolean>(true)
    val showNotification= MutableLiveData<Boolean>(true)
    val showfilter = MutableLiveData<Boolean>(true)
    val showNavigation= MutableLiveData<Boolean>(true)
    val showTitle= MutableLiveData<Boolean>(true)
    val toolbars = MutableLiveData<Boolean>(true)
    init {
        title.value="Home"
    }


    companion object {
        private var instance : HomeActViewModel? = null
        fun getInstance() =
            instance ?: synchronized(HomeActViewModel::class.java){
                instance ?: HomeActViewModel().also { instance = it }
            }
    }


}