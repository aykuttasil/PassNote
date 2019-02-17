package aykuttasil.com.passnote.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.biometrics.BiometricPrompt
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.authentication.EncryptionServices
import aykuttasil.com.passnote.data.Storage
import aykuttasil.com.passnote.ui.common.BaseSecureActivity
import aykuttasil.com.passnote.ui.main.MainActivity
import aykuttasil.com.passnote.util.SystemServices
import aykuttasil.com.passnote.util.extension.hideKeyboard
import aykuttasil.com.passnote.util.extension.openSecuritySettings
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.concurrent.Executor

/**
 * Sign up with password screen.
 */
class SignUpActivity : BaseSecureActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initViews()
    }

    private fun initViews() {
        confirmPasswordView.setOnEditorActionListener { _, id, _ -> onEditorActionClick(id) }
        doneView.setOnClickListener { attemptToSignUp() }

        if (systemServices.isFingerprintHardwareAvailable()) {
            allowFingerprintView.visibility = View.VISIBLE
        }
        allowFingerprintView.setOnCheckedChangeListener { _, checked -> onAllowFingerprint(checked) }
    }

    private fun onAllowFingerprint(checked: Boolean) {
        if (checked && !systemServices.hasEnrolledFingerprints()) {
            allowFingerprintView.isChecked = false
            Snackbar.make(signUpRootView, R.string.sign_up_snack_message, Snackbar.LENGTH_LONG)
                    .setAction(R.string.sign_up_snack_action) { openSecuritySettings() }
                    .show()
        }
    }

    private fun onEditorActionClick(id: Int): Boolean = when (id) {
        EditorInfo.IME_ACTION_DONE, EditorInfo.IME_NULL -> {
            attemptToSignUp()
            true
        }
        else -> false
    }

    /**
     * Attempts to sign up with password specified by the sing up form.
     * If there are form errors errors are presented and no actual sing up attempt is made.
     */
    private fun attemptToSignUp() {
        passwordHolderView.error = null
        confirmPasswordHolderView.error = null

        val passwordString = passwordView.text.toString()
        val confirmPasswordString = confirmPasswordView.text.toString()

        var cancel = false
        var focusView: View? = null

        if (!isPasswordValid(passwordString)) {
            passwordHolderView.error = getString(R.string.sign_up_error_invalid_password)
            focusView = passwordView
            cancel = true
        } else if (passwordString != confirmPasswordString) {
            confirmPasswordHolderView.error = getString(R.string.sign_up_error_incorrect_password)
            focusView = confirmPasswordView
            cancel = true
        }

        if (cancel) {
            focusView?.requestFocus()
        } else {
            createKeys(passwordString, allowFingerprintView.isChecked)

            with(Storage(this)) {
                val encryptedPassword = EncryptionServices(applicationContext).encrypt(passwordString, passwordString)
                //logi("Original password is: $passwordString")
                //logi("Saved password is: $encryptedPassword")

                savePassword(encryptedPassword)
                saveFingerprintAllowed(allowFingerprintView.isChecked)
            }

            focusView?.hideKeyboard()
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * Create master, fingerprint and confirm credentials keys.
     */
    private fun createKeys(password: String, isFingerprintAllowed: Boolean) {
        val encryptionService = EncryptionServices(applicationContext)
        encryptionService.createMasterKey(password)

        if (SystemServices.hasMarshmallow()) {
            if (isFingerprintAllowed && systemServices.hasEnrolledFingerprints()) {
                encryptionService.createFingerprintKey()
            }
            encryptionService.createConfirmCredentialsKey()
        }
    }

    private fun isPasswordValid(password: String) = !TextUtils.isEmpty(password) && password.length >= 6

    fun a() {
        val biometricPrompt = BiometricPrompt(this, Executor {

        }, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Haydi Bakalım")
                .build()
        biometricPrompt.authenticate(promptInfo)
    }
}
