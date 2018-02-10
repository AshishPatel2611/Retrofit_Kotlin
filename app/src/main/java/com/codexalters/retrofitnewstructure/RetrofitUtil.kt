package com.codexalters.retrofitnewstructure

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by codexalters on 9/2/18.
 */
object RetrofitUtil {

    interface DataHandler {
        fun onSuccess(data: JsonElement)
        fun onFailure(data: String)
        fun loginRequired()
        fun noInternetConnection()
    }

    fun handleApiResponse(apiCall: Call<APIresponse>, dataHandler: DataHandler) {

        apiCall.enqueue(object : Callback<APIresponse> {

            override fun onFailure(call: Call<APIresponse>?, t: Throwable?) {

                dataHandler.onFailure("Failure")
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<APIresponse>?, response: Response<APIresponse>?) {

                if (response!!.body() != null) {
                    if (response.body()!!.status == 200) {

                        dataHandler.onSuccess(response.body()!!.data!!)

                    } else if (response.body()!!.status == 401) {

                        dataHandler.loginRequired()

                    } else if (response.body()!!.status == 404) {

                        dataHandler.onFailure(response.body()!!.message)

                    } else {

                        dataHandler.onFailure(response.body()!!.message)
                    }
                } else {
                    dataHandler.onFailure("Retrofit error")
                }
            }
        })
    }

    class APIresponse {
        @SerializedName("status")
        val status: Int? = null
        @SerializedName("message")
        val message: String = ""
        @SerializedName("data")
        val data: JsonElement? = null
    }
}