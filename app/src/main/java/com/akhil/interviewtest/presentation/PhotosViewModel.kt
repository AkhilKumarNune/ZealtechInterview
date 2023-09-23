package com.akhil.interviewtest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akhil.interviewtest.data.model.PhotoResponse
import com.akhil.interviewtest.domain.GetPhotosUserCase
import kotlinx.coroutines.launch

class PhotosViewModel(val photosUserCase: GetPhotosUserCase) : ViewModel() {

    val photosMutableData = MutableLiveData<PhotoResponse>()

    val photosLiveData : LiveData<PhotoResponse> get() =  photosMutableData

    fun getPhotos(){
        viewModelScope.launch {
            val photoResponse = photosUserCase.execute()
            if (photoResponse.isSuccessful){
                if (photoResponse.body() != null){
                    photosMutableData.value = photoResponse.body()!!
                }
            }
        }
    }

}