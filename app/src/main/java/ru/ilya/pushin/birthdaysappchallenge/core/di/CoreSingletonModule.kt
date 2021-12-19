package ru.ilya.pushin.birthdaysappchallenge.core.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ilya.pushin.birthdaysappchallenge.BuildConfig
import ru.ilya.pushin.birthdaysappchallenge.core.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreSingletonModule {

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            builder.addInterceptor(interceptor)
        }

        return builder
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        return builder
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideRetrofit(builder: Retrofit.Builder, okHttpClient: OkHttpClient): Retrofit {
        return builder
            .client(okHttpClient)
            .build()
    }

    @MainCoroutineDispatcher
    @Provides
    fun provideMainCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @IoCoroutineDispatcher
    @Provides
    fun provideIoCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DefaultCoroutineDispatcher
    @Provides
    fun provideDefaultCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
