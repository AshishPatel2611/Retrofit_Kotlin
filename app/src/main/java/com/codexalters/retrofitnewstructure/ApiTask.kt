package com.codexalters.retrofitnewstructure

import android.app.Activity
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiTask {

    private val webService: WebServices

    init {
        val gson = GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create()
        val client = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(WebServices.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        webService = retrofit.create(WebServices::class.java)
    }

    fun getCategoryList(token: String, dataHandler: RetrofitUtil.DataHandler, activity: Activity) {

        if (ConnectionUtil.isDataConnectionAvailable(activity)) {
            RetrofitUtil.handleApiResponse(webService.getCategoryList(token), dataHandler)
        } else {
            dataHandler.noInternetConnection()
        }
    }

    fun getIndexDetailByIndexId(token: String, indexId: String, dataHandler: RetrofitUtil.DataHandler, activity: Activity) {
        if (ConnectionUtil.isDataConnectionAvailable(activity)) {
            RetrofitUtil.handleApiResponse(webService.getIndexDetailByIndexId(token, indexId), dataHandler)
        } else {
            dataHandler.noInternetConnection()

        }

    }


}