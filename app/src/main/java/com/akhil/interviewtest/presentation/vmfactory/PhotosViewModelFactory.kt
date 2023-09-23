package com.akhil.interviewtest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akhil.interviewtest.domain.GetPhotosUserCase

class PhotosViewModelFactory(val photosUserCase: GetPhotosUserCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotosViewModel(photosUserCase) as T
    }
}