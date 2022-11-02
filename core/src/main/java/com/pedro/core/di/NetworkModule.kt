package com.pedro.core.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com"

val networkModule = module {
    single {
        createService()
    }
}

private fun createService(): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(createOkHttpClient())
    .build()

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header(
                        "X-RapidAPI-Key",
                        "b7c737731bmsh5ed2c0a3cfa12aap16f360jsn117616299d3e"
                    )
                    builder.header(
                        "X-RapidAPI-Host",
                        "omgvamp-hearthstone-v1.p.rapidapi.com"
                    )
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()
}