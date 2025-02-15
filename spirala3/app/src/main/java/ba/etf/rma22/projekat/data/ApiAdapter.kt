package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.repositories.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {
    val retrofit : Api = Retrofit.Builder()
        .baseUrl(ApiConfig.getUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)
}

