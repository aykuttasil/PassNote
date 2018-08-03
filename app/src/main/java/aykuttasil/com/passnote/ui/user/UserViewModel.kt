package aykuttasil.com.passnote.ui.user

import androidx.lifecycle.AndroidViewModel
import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.passnote.App
import javax.inject.Inject

/**
 * Created by aykutasil on 27.12.2017.
 */
class UserViewModel @Inject constructor(val app: App, private val dataManager: DataManager) : AndroidViewModel(app) {

}