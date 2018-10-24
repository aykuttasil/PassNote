package aykuttasil.com.passnote.data.repository

import androidx.lifecycle.LiveData
import aykuttasil.com.passnote.data.Resource
import aykuttasil.com.passnote.data.remote.ApiResponse
import aykuttasil.com.passnote.data.remote.ApiService
import aykuttasil.com.passnote.data.remote.NetworkBoundResource
import aykuttasil.com.passnote.data.remote.model.Repo
import aykuttasil.com.passnote.util.AppExecutors
import javax.inject.Inject

/**
 * Created by aykutasil on 1.03.2018.
 */
class RepoRepository @Inject constructor(val apiService: ApiService, val appExecutors: AppExecutors) {

    fun getUserRepos(user: String): LiveData<Resource<Repo>> {
        return object : NetworkBoundResource<Repo, Repo>(appExecutors) {
            override fun saveCallResult(item: Repo) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun shouldFetch(data: Repo?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun loadFromDb(): LiveData<Repo> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun createCall(): LiveData<ApiResponse<Repo>> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        }.asLiveData()
    }

}