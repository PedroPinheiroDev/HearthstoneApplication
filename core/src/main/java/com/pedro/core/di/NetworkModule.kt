package com.pedro.core.di

import com.pedro.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
const val TIMEOUT = 100L

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
                    builder.addHeader(
                        BuildConfig.KEY,
                        BuildConfig.KEY_VALUE
                    )
                    builder.addHeader(
                        BuildConfig.HOST,
                        BuildConfig.HOST_VALUE
                    )
                    return@Interceptor chain.proceed(builder.build())
                }
            )
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        }.build()
}
