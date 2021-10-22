package com.example.kotlinretrofitlearning

import NewResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "4f8b602cd4d640b6b83f307d4aedd7d4"
const val BASE_URL = "https://newsapi.org/"

//https://newsapi.org/v2/top-headlines?country=us&apiKey=4f8b602cd4d640b6b83f307d4aedd7d4

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getNewsAsync(@Query("country") country: String,@Query("page") page:Int): Call<NewResponse>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}