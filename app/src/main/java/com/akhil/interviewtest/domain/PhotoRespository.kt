package com.akhil.interviewtest.domain

import com.akhil.interviewtest.data.model.PhotoResponse
import retrofit2.Response

interface PhotoRespository {
    suspend fun getPhotos() : Response<PhotoResponse>
}