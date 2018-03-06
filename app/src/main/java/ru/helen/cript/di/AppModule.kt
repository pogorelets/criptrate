package ru.helen.cript.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.helen.cript.api.CriptService
import javax.inject.Singleton

/**
 * Created by lenap on 02.03.2018.
 */

@Module
class AppModule(var context: Context) {
    private val BASE_URL = "https://api.coinmarketcap.com/"

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCriptService(retrofit : Retrofit) = retrofit.create(CriptService::class.java)


}