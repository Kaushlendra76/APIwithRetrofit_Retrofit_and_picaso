package com.example.apiwithretrofit

import Apidata
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var myrecyclerView : RecyclerView
    lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myrecyclerView = findViewById(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface ::class.java)

        val retrofitdata = retrofitBuilder.getProductData()
        retrofitdata.enqueue(object : Callback<Apidata?> {
            override fun onResponse(call: Call<Apidata?>, response: Response<Apidata?>) {
                // if API hit successfully then excute this code in application
                val responseBody = response.body()
                val products = responseBody?.products!!

                val stringBuilderforcollectdata = StringBuilder()


                for (Apidata in products){
                    stringBuilderforcollectdata.append(Apidata.title + " ")

                }
                val tv = findViewById<TextView>(R.id.textView)
                tv.text = stringBuilderforcollectdata


                myAdapter = MyAdapter(this@MainActivity, products)
                myrecyclerView.adapter = myAdapter
                myrecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<Apidata?>, t: Throwable) {
                Log.d("Main Activity", "onFailure" + t.message)
            }
        })
    }
}