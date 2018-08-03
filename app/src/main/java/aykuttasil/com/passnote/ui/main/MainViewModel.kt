package aykuttasil.com.passnote.ui.main

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.passnote.App
import aykuttasil.com.passnote.data.Resource
import aykuttasil.com.passnote.data.local.entity.UserEntity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by aykutasil on 27.12.2017.
 */
class MainViewModel @Inject constructor(val app: App, private val dataManager: DataManager) : AndroidViewModel(app) {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val liveUserName: MutableLiveData<String> = MutableLiveData()


    fun getUser(username: String): LiveData<Resource<UserEntity>> {
        liveUserName.postValue(username)
        return Transformations.switchMap(liveUserName, {
            dataManager.getUser(it)
        })
    }

    fun retryGetUser(username: String) {
        liveUserName.value = username
    }

    /*
    fun startSaveLocation(): LiveData<Location> {
        return LocationLiveData(app, dataManager)
    }

    fun getLastLocationFromDb(): LiveData<List<LocationEntity>> {
        return dataManager.getLocations()
    }

    fun getLastLocationFromDbRx(): Flowable<List<LocationEntity>> {
        return dataManager.getLocationsRx()
    }

    fun addSampleUser(user: UserEntity) {
        compositeDisposable.add(dataManager.addUserToLocal(user)?.subscribeOn(Schedulers.io())!!.subscribe())
    }


    fun loadUsers(): Flowable<ResourceSealed<List<UserEntity>>> {
        return object : NetworkBoundResourceRx<List<UserEntity>, NetworkResponse<UserResponse>>(app) {
            override fun saveCallResult(request: NetworkResponse<UserResponse>) {

            }

            override fun loadFromDb(): Flowable<List<UserEntity>> {

            }

            override fun createCall(): Flowable<Response<NetworkResponse<UserResponse>>> {

            }
        }.asFlowable()
    }*/


    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}