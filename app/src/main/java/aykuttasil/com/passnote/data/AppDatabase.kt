package aykuttasil.com.passnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import aykuttasil.com.passnote.data.local.dao.LocationDao
import aykuttasil.com.passnote.data.local.dao.UserDao
import aykuttasil.com.passnote.data.local.entity.LocationEntity
import aykuttasil.com.passnote.data.local.entity.UserEntity
import aykuttasil.com.passnote.util.converter.RoomTypeConverter

@Database(
        entities = [
            (UserEntity::class),
            (LocationEntity::class)
        ],
        version = 1)
@TypeConverters(RoomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getLocationDao(): LocationDao
}