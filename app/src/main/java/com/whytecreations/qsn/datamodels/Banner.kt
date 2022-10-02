package com.whytecreations.qsn.datamodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("photo")
    @Expose
    val photo: String = "",

    )
