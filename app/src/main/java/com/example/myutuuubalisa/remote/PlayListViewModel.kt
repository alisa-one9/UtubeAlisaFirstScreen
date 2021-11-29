package com.example.myutuuubalisa.remote

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myutuuubalisa.`object`.Constant
import com.example.myutuuubalisa.model.PlayList
import com.example.myutuuubalisa.networkConnect.NetworkConnectivityRealTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListViewModel : ViewModel() {

    private val youTubeApi:YouTubeApi = RetrofitClient.create()

    fun getPlayList(): LiveData<PlayList> {
        return createCall()
    }


    private fun createCall(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()

        youTubeApi.getPlayList(Constant.PART, Constant.CHANNEL_ID, "AIzaSyDvV2LxBCRQ-m_P-XFpEbat-gaT4PWUORc")
            .enqueue(object : Callback<PlayList> {
                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    if (response.isSuccessful && response.body() != null) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    print(t.stackTrace)
                    Log.e("ololo", "onFailure : ${t.stackTrace} - ${t.localizedMessage}")
                }
            })
        return data
    }
}