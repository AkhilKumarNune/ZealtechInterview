package com.akhil.interviewtest.data

import com.akhil.interviewtest.data.model.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {
    //https://api.slingacademy.com/v1/sample-data/photos
    @GET("sample-data/photos")
    suspend fun getTitles() : Response<PhotoResponse>
}