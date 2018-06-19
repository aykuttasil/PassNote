package aykuttasil.com.passnote.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import aykuttasil.com.passnote.data.local.entity.LocationEntity
import io.reactivex.Flowable

/**
 * Created by aykutasil on 27.12.2017.
 */
@Dao
abstract class LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItems(list: List<LocationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItem(item: LocationEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updatetItem(item: LocationEntity)

    @Delete
    abstract fun deleteItem(item: LocationEntity)

    @Query("SELECT * FROM location")
    abstract fun getItems(): Flowable<List<LocationEntity>>

    @Query("SELECT * FROM location")
    abstract fun getItemsLiveData(): LiveData<List<LocationEntity>>

    @Query("SELECT * FROM location WHERE locationId=:id")
    abstract fun getItem(id: Long): LocationEntity

    @Insert
    abstract fun insertAll(vararg locations: LocationEntity)
}