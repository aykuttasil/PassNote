package aykuttasil.com.passnote.data

import android.arch.lifecycle.LiveData
import aykuttasil.com.passnote.data.local.entity.LocationEntity
import aykuttasil.com.passnote.data.local.entity.UserEntity

/**
 * Created by aykutasil on 27.12.2017.
 */
interface IDataManager {

    fun addLocation(loc: LocationEntity)

    fun getUser(username: String): LiveData<Resource<UserEntity>>

}