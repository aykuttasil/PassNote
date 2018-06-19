package aykuttasil.com.passnote.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import aykuttasil.com.passnote.data.local.dao.LocationDao
import aykuttasil.com.passnote.data.local.dao.UserDao
import aykuttasil.com.passnote.data.local.entity.LocationEntity
import aykuttasil.com.passnote.data.local.entity.UserEntity
import aykuttasil.com.passnote.util.converter.RoomTypeConverter

@Database(
        entities = [(UserEntity::class), (LocationEntity::class)],
        version = 4)
@TypeConverters(RoomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getLocationDao(): LocationDao
}