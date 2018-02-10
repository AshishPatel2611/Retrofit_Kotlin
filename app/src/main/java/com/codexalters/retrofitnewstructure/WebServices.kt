package com.codexalters.retrofitnewstructure

import retrofit2.Call
import retrofit2.http.*

interface WebServices {

    companion object {
     
        const val BASE_URL = "http://ws/"
        const val CATEGORY_LIST = "user/user/getCategorylist"
        const val INDEX_DETAIL = "user/user/IndexDetails"
    }

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET(CATEGORY_LIST)
    fun getCategoryList(@Header("vAuthToken") token: String): Call<RetrofitUtil.APIresponse>

    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST(INDEX_DETAIL)
    fun getIndexDetailByIndexId(@Header("vAuthToken") token: String,
                                @Field("vIndexId") indexId: String): Call<RetrofitUtil.APIresponse>

}
