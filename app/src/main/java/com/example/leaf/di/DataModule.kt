package com.example.leaf.di

import android.util.Log
import com.example.leaf.core.Constants.BASE_URL
import com.example.leaf.core.Constants.OK_HTTP
import com.example.leaf.data.remote.network.BookSearchServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    
    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.i(OK_HTTP, it)
        }.apply { level = HttpLoggingInterceptor.Level.BODY }
        
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
    
    @Provides
    @Singleton
    fun providesBookSearchServices(client: OkHttpClient): BookSearchServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        
        return retrofit.create(BookSearchServices::class.java)
        
    }
}