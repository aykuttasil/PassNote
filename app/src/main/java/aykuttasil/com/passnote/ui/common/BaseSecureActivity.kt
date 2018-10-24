package aykuttasil.com.passnote.ui.common

import androidx.appcompat.app.AlertDialog
import aykuttasil.com.passnote.util.SystemServices

abstract class BaseSecureActivity : BaseActivity() {
    val systemServices by lazy(LazyThreadSafetyMode.NONE) { SystemServices(this) }

    private var deviceSecurityAlert: AlertDialog? = null

    override fun onStart() {
        super.onStart()
        if (!systemServices.isDeviceSecure()) {
            deviceSecurityAlert = systemServices.showDeviceSecurityAlert()
        }
    }

    override fun onStop() {
        super.onStop()
        deviceSecurityAlert?.dismiss()
    }
}