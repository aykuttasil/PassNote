package aykuttasil.com.passnote.ui.main.pages.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.data.Storage
import aykuttasil.com.passnote.databinding.FragmentMainBinding
import aykuttasil.com.passnote.di.Injectable
import aykuttasil.com.passnote.ui.common.BaseSecureFragment
import aykuttasil.com.passnote.util.delegates.Inflate
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainFragment : BaseSecureFragment(), Injectable {

    private val binding: FragmentMainBinding by Inflate(R.layout.fragment_main)
    private val storage: Storage by lazy(LazyThreadSafetyMode.NONE) { Storage(context!!.applicationContext) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGoUserActivity.onClick {
            Navigation.findNavController(binding.btnGoUserActivity).navigate(R.id.action_mainFragment_to_aboutFragment)
        }

        btnImagePicker.onClick {
            //x()
        }
    }


    /*
    fun x() {
        val dialog = AuthenticationDialog()
        if (storage.isFingerprintAllowed() && systemServices.hasEnrolledFingerprints()) {
            dialog.cryptoObjectToAuthenticateWith = EncryptionServices(context!!).prepareFingerprintCryptoObject()
            dialog.fingerprintInvalidationListener = { onFingerprintInvalidation(it) }
            dialog.fingerprintAuthenticationSuccessListener = { validateKeyAuthentication(secret, it) }
            if (dialog.cryptoObjectToAuthenticateWith == null) dialog.stage = AuthenticationDialog.Stage.NEW_FINGERPRINT_ENROLLED else dialog.stage = AuthenticationDialog.Stage.FINGERPRINT
        } else {
            dialog.stage = AuthenticationDialog.Stage.PASSWORD
        }
        dialog.authenticationSuccessListener = { startSecretActivity(ADD_SECRET_REQUEST_CODE, SecretActivity.MODE_VIEW, it, secret) }
        dialog.passwordVerificationListener = { validatePassword(it) }
        dialog.show(childFragmentManager, "Authentication")
    }
    */
}