package aykuttasil.com.passnote.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import aykuttasil.com.passnote.data.Resource
import aykuttasil.com.passnote.data.local.dao.UserDao
import aykuttasil.com.passnote.data.local.entity.UserEntity
import aykuttasil.com.passnote.data.remote.ApiResponse
import aykuttasil.com.passnote.data.remote.ApiService
import aykuttasil.com.passnote.data.remote.NetworkBoundResource
import aykuttasil.com.passnote.data.remote.model.User
import aykuttasil.com.passnote.util.AppExecutors
import javax.inject.Inject

/**
 * Created by aykutasil on 3.02.2018.
 */
class UserRepository @Inject constructor(val apiService: ApiService, val userDao: UserDao, val appExecutors: AppExecutors) {

    fun getUser(username: String): LiveData<Resource<UserEntity>> {
        return object : NetworkBoundResource<UserEntity, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                val userEntity = UserEntity(_UserName = item.name, UserEmail = item.login, _UserJob = "Developer")
                userDao.insertItem(userEntity)
            }

            override fun shouldFetch(data: UserEntity?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<UserEntity> {
                return userDao.getItem(username)
            }

            override fun createCall(): LiveData<ApiResponse<User>> {
                return Transformations.map(apiService.getUser(username)) {
                    val toplam = (1..1000000).sum()
                    println(toplam)
                    it
                }
            }

        }.asLiveData()
    }

}