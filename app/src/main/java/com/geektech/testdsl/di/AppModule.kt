package com.geektech.testdsl.di

import android.content.Context
import androidx.room.Room
import com.geektech.testdsl.data.local.NoteDao
import com.geektech.testdsl.data.local.NoteDataBase
import com.geektech.testdsl.data.repo.NoteRepoImpl
import com.geektech.testdsl.domain.repository.NoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDataBase::class.java, "db")
            .build()

    @Singleton
    @Provides
    fun provideDao(noteDataBase: NoteDataBase) =
        noteDataBase.dao()

    @Singleton
    @Provides
    fun noteRepository(noteDao: NoteDao): NoteRepo {
        return NoteRepoImpl(noteDao)
    }

}