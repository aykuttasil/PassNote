package aykuttasil.com.passnote.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import aykuttasil.com.passnote.data.AppDatabase
import aykuttasil.com.passnote.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by aykutasil on 20.12.2017.
 */
@Module
class DatabaseModule {

    companion object {
        const val DB_NAME = "aa.db"
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase) = db.getUserDao()

    @Provides
    @Singleton
    fun provideLocationDao(db: AppDatabase) = db.getLocationDao()

}