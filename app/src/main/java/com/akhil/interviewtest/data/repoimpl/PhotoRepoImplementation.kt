package com.akhil.interviewtest.data

import com.akhil.interviewtest.data.model.PhotoResponse
import com.akhil.interviewtest.domain.PhotoRespository
import retrofit2.Response

class PhotoRepoImplementation(val apiInterface: APIInterface) : PhotoRespository {
    override suspend fun getPhotos(): Response<PhotoResponse> {
        return apiInterface.getTitles()
    }
}