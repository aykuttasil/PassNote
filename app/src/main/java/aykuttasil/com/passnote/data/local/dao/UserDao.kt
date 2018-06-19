package aykuttasil.com.passnote.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import aykuttasil.com.passnote.data.local.entity.UserEntity
import io.reactivex.Flowable

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItems(list: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItem(item: UserEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updatetItem(item: UserEntity)

    @Delete
    abstract fun deletetItem(item: UserEntity)

    @Query("SELECT count(*) FROM user")
    abstract fun getItemsCount(): Flowable<Int>

    @Query("SELECT * FROM user")
    abstract fun getItems(): Flowable<List<UserEntity>>

    @Query("SELECT * FROM user")
    abstract fun getItemsLiveData(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE UserId=:id")
    abstract fun getItem(id: Long): UserEntity

    @Query("SELECT * FROM user")
    abstract fun getItem(): LiveData<UserEntity>

    @Query("SELECT * FROM user WHERE UserEmail=:username")
    abstract fun getItem(username: String): LiveData<UserEntity>

    @Insert
    abstract fun insertAll(vararg users: UserEntity)

}