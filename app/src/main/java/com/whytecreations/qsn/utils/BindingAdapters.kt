package com.whytecreations.qsn.utils


import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

import com.bumptech.glide.Glide

//object BindingAdapters {
//    @JvmStatic
//    @BindingAdapter("android:src")
//    fun setImage(imageView: ImageView, image: String?) {
//        image?.let {
//            Glide.with(imageView.context)
//                .load(it)
//                .centerCrop()
//                .into(imageView)
//        }
//
//
//    }



@BindingAdapter("app:srcCompat")
fun srcCompat(view: ImageView, @DrawableRes drawableId: Int) {
    drawableId.let {
            Glide.with(view.context)
               .load(it)
                .override(100,100)
                .fitCenter()
               .into(view)
      }
        //view.setImageResource(drawableId)
}


//}
//@BindingAdapter("android:src")
//fun setImageViewResource(imageView: ImageView, resource: Int) {
//    imageView.setImageResource(resource)
//}
//@BindingAdapter("android:src")
//fun setImageViewResource(imageView: ImageView, resource: Drawable) {
//    imageView.setImageDrawable(resource)
//}