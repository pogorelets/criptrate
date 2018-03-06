package ru.helen.cript.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * rest client
 */
class RestClient {
    private var instance: RestClient ? = null
    private val BASE_URL = "https://api.coinmarketcap.com/"
    val criptAPI: CriptService
    val retrofit :Retrofit
    internal val okHttpClient = OkHttpClient.Builder()
            .readTimeout(600, TimeUnit.SECONDS)
            .connectTimeout(600, TimeUnit.SECONDS)
            .build()

    init {
         retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()

         criptAPI = retrofit.create(CriptService::class.java)
    }

    fun getApi(): CriptService = criptAPI

    fun getInstance(): RestClient {
        if (instance == null) {
            instance = RestClient()
        }
        return instance as RestClient
    }
}

