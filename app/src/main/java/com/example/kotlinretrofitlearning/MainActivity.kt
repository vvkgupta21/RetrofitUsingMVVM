package com.example.kotlinretrofitlearning

import NewResponse
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt = findViewById<TextView>(R.id.text)
        txt.setOnClickListener {
            getNews()

        }

    }

    private fun getNews() {
        val news = NewsService.newsInstance.getNewsAsync("in",1)
        news.enqueue(object : Callback<NewResponse>{
            override fun onResponse(call: Call<NewResponse>, response: Response<NewResponse>) {
                val responseCall = response.body()
                if (responseCall != null){
                    Log.d(TAG, "onResponse: $responseCall")
                }
            }

            override fun onFailure(call: Call<NewResponse>, t: Throwable) {
                Log.d(TAG, "Failure",t)
            }

        })
    }
}