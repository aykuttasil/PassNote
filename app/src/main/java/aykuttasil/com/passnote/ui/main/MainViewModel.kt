package aykuttasil.com.passnote.ui.main

import aykuttasil.com.myandroidstructure.data.DataManager
import aykuttasil.com.passnote.App
import aykuttasil.com.passnote.util.RxAwareViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(val app: App, private val dataManager: DataManager) : RxAwareViewModel(app) {

}