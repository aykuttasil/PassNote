package aykuttasil.com.passnote.util

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by mertsimsek on 22/11/2017.
 */
open class RxAwareViewModel : ViewModel() {

    var disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}