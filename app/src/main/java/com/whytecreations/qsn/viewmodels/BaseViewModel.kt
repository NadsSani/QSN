package com.whytecreations.qsn.viewmodels



import android.graphics.drawable.Drawable
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import me.tatarka.bindingcollectionadapter2.ItemBinding

import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.whytecreations.qsn.BR
import com.whytecreations.qsn.R
import com.whytecreations.qsn.datamodels.Banner
import com.whytecreations.qsn.datamodels.BaseModel
import com.whytecreations.qsn.listeners.ItemSelectListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import kotlin.coroutines.CoroutineContext


import me.tatarka.bindingcollectionadapter2.OnItemBind





open class BaseViewModel:ViewModel() {

    val items2 = ObservableArrayList<BaseModel>()
    val banneritem = ObservableArrayList<Banner>()
    val selecteditem = LiveEvent<BaseModel>()
    val dummy = MutableLiveData<Boolean>(true)
//=================================
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val coroutineMainContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    val scope = CoroutineScope(coroutineContext)
    val mainScope = CoroutineScope(coroutineMainContext)

    fun cancelAllRequests() = coroutineContext.cancel()
    var lastSelectedCategory = 0
  //============================


    private val selectcartype = object : ItemSelectListener<BaseModel> {

        override fun onItemSelected(item: BaseModel) {
            val lastCategor = items2[lastSelectedCategory]
            lastCategor.isSelected = false
            items2[lastSelectedCategory] = lastCategor

            val position = items2.indexOf(item)
            item.isSelected = true
            items2[position] = item

            lastSelectedCategory = position
            selecteditem.value = item
        }
    }
    val itemBinding2:OnItemBindClass<BaseModel> = OnItemBindClass<BaseModel>().map(
        BaseModel::class.java
    ) { itemBinding, position, item ->
        itemBinding.set(BR.carnumbers, R.layout.carnumbercardscategory)

        itemBinding.bindExtra(BR.listener,selectcartype )
    }


    val itemBinding2Modified: OnItemBind<BaseModel> =
        OnItemBind { itemBinding, position, item ->
            itemBinding.set(
                BR.carnumbers,
                if(item.type == 1) R.layout.carnumbercardscategory else R.layout.cardsforimage)

            itemBinding.bindExtra(BR.listener,selectcartype )
        }


    val bannerItemBinding =
        ItemBinding.of<Banner>(BR.banner, R.layout.swipingcards)



    fun carselected() {
        lastSelectedCategory = 0
                   items2.clear()
                    items2.add(BaseModel("Private",true))
                    items2.add(BaseModel("Commercial"))
                    items2.add(BaseModel("Bikes Qatar"))
                }



   fun phoneselected(){
       lastSelectedCategory = 0
       items2.clear()
       items2.add(BaseModel("oreedo",true,type=2,image =R.drawable.image_10 ))
       items2.add(BaseModel("vodafone",type=2,image =R.drawable.vodafone))
       items2.add(BaseModel("Land Line"))


   }
    fun fillbanner(){
        banneritem.add(Banner("https://mmmagicalstore.com/work/assets/images/sliders/1624870923.jpg"))
        banneritem.add(Banner("https://mmmagicalstore.com/work/assets/images/sliders/1624870957.png"))
        banneritem.add(Banner("https://mmmagicalstore.com/work/assets/images/sliders/1624870957.png"))
        banneritem.add(Banner("https://mmmagicalstore.com/work/assets/images/sliders/1624870957.png"))
        banneritem.add(Banner("https://mmmagicalstore.com/work/assets/images/sliders/1624870957.png"))

    }


}