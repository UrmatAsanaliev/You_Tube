package com.example.ru_tube.data.network

import com.example.ru_tube.BuildConfig
import com.example.ru_tube.data.remove.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module{
    single { provideOkkHttpClient() }
    single { provideApi(get())}
    single { provideRetrofit(get()) }
}


fun provideApi(retrofit: Retrofit) : ApiService {
    return retrofit.create(ApiService::class.java)
}

fun provideRetrofit(okkHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .client(okkHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkkHttpClient() : OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}