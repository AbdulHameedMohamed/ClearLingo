package com.example.clearlingo.feature_lingo.di

import android.app.Application
import androidx.room.Room
import com.example.clearlingo.feature_lingo.data.local.Converters
import com.example.clearlingo.feature_lingo.data.local.WordInfoDatabase
import com.example.clearlingo.feature_lingo.data.remote.DictionaryApi
import com.example.clearlingo.feature_lingo.data.repository.WordInfoRepositoryImpl
import com.example.clearlingo.feature_lingo.data.util.GsonParser
import com.example.clearlingo.feature_lingo.domain.repository.WordInfoRepository
import com.example.clearlingo.feature_lingo.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}