package com.akhil.interviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.akhil.interviewtest.data.APIInterface
import com.akhil.interviewtest.data.ApiClient
import com.akhil.interviewtest.data.PhotoRepoImplementation
import com.akhil.interviewtest.domain.GetPhotosUserCase
import com.akhil.interviewtest.presentation.PhotosViewModel
import com.akhil.interviewtest.presentation.PhotosViewModelFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this is manual dependency injection
        // to avoid this boilerplate code, dependency injection libraries like Dagger is used
        val apiInterface = ApiClient.getInstance().create(APIInterface::class.java)
        val photoRepoImplementation = PhotoRepoImplementation(apiInterface)
        val getPhotosUserCase = GetPhotosUserCase(photoRepoImplementation)
        val viewModelFactory = PhotosViewModelFactory(getPhotosUserCase)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(PhotosViewModel::class.java)

        val textView = findViewById<TextView>( R.id.photoTitles)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        viewModel.photosLiveData.observe(this) {
            if (it.success){
                val photos = it.photos
                val stringBuilder = StringBuilder()

                photos.forEach {photo ->
                    stringBuilder.append(photo.title)
                    stringBuilder.append("\n\n")
                    Log.e(TAG, "onCreate: ${photo.title}" )
                }
                textView.text = stringBuilder.toString()
                progressBar.visibility = View.GONE

            }
        }

        viewModel.getPhotos()
        progressBar.visibility = View.VISIBLE

    }
    companion object{
        const val TAG="MainActivity"
    }
}