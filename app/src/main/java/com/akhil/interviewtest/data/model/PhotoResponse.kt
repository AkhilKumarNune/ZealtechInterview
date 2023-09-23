package com.akhil.interviewtest.data.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(@SerializedName("success") val success : Boolean,
                         @SerializedName("message") val message : String,
                         @SerializedName("total_photos") val total_photos : Int,
                         @SerializedName("photos") val photos : ArrayList<Photo>)
