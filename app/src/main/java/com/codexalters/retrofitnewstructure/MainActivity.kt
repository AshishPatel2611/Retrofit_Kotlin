package com.codexalters.retrofitnewstructure

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var categoryList: List<CategoryBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt.setOnClickListener {

            ApiTask.getCategoryList(
                    "Bearer UiVCQyUyOSU2MHglMDklQkMlQTUlQjQlOTAlRTMlQTUlN0UlQTBzJUNGJTI1JTNCJUFBJUQwMmNkMTExN2I5Yjg4NGRh",
                    object : RetrofitUtil.DataHandler {

                        override fun onSuccess(data: String) {
                            categoryList = Gson().fromJson(data, object : TypeToken<List<CategoryBean>>() {}.type)
                            Toast.makeText(this@MainActivity, categoryList!!.get(0).toString(), Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(data: String) {
                            // handle error here
                            Toast.makeText(this@MainActivity, data, Toast.LENGTH_SHORT).show()
                        }

                        override fun loginRequired() {
                            Toast.makeText(this@MainActivity, "Login Again", Toast.LENGTH_SHORT).show()
                        }

                        override fun noInternetConnection() {
                            Toast.makeText(this@MainActivity, "No Internet Connection", Toast.LENGTH_SHORT).show()
                        }

                    }, this)
        }

        txt1.setOnClickListener {

            ApiTask.getIndexDetailByIndexId(
                    "Bearer UiVCQyUyOSU2MHglMDklQkMlQTUlQjQlOTAlRTMlQTUlN0UlQTBzJUNGJTI1JTNCJUFBJUQwMmNkMTExN2I5Yjg4NGRh",
                    "18",
                    object : RetrofitUtil.DataHandler {

                        override fun onSuccess(data: String) {
                            val indexDetail: IndexDetailBean = Gson().fromJson(data, object : TypeToken<IndexDetailBean>() {}.type)
                            Toast.makeText(this@MainActivity, indexDetail.vCompanyName, Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(data: String) {
                            // handle error here
                            Toast.makeText(this@MainActivity, data, Toast.LENGTH_SHORT).show()
                        }

                        override fun loginRequired() {
                            Toast.makeText(this@MainActivity, "Login Again", Toast.LENGTH_SHORT).show()
                        }

                        override fun noInternetConnection() {
                            Toast.makeText(this@MainActivity, "No Internet Connection", Toast.LENGTH_SHORT).show()
                        }
                    }, this)

        }
    }

}
