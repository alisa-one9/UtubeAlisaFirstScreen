package com.example.myutuuubalisa.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {

        fun create():YouTubeApi {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel((HttpLoggingInterceptor.Level.BODY))


            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/youtube/v3")
                .client(okHttpClient)
                .build()

            return retrofit.create(YouTubeApi::class.java)


        }
    }
}
