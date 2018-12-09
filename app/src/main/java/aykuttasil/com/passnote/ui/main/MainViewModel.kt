package aykuttasil.com.passnote.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.passnote.App
import aykuttasil.com.passnote.data.Resource
import aykuttasil.com.passnote.data.local.entity.UserEntity
import aykuttasil.com.passnote.util.RxAwareViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(val app: App, private val dataManager: DataManager) : RxAwareViewModel(app) {

    private val liveUserName: MutableLiveData<String> = MutableLiveData()

    fun getUser(username: String): LiveData<Resource<UserEntity>> {
        liveUserName.postValue(username)
        return Transformations.switchMap(liveUserName) {
            dataManager.getUser(it)
        }
    }

    fun retryGetUser(username: String) {
        liveUserName.value = username
    }
}