package com.akhil.interviewtest.domain

import com.akhil.interviewtest.data.PhotoRepoImplementation
import com.akhil.interviewtest.data.model.PhotoResponse
import retrofit2.Response

class GetPhotosUserCase(val photoRespository: PhotoRespository) {
    suspend fun execute() : Response<PhotoResponse>{
        return photoRespository.getPhotos()
    }
}