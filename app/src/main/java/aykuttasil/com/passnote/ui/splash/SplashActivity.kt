package aykuttasil.com.passnote.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.data.Storage
import aykuttasil.com.passnote.ui.common.BaseActivity
import aykuttasil.com.passnote.ui.main.MainActivity
import aykuttasil.com.passnote.ui.signup.SignUpActivity

class SplashActivity : BaseActivity() {

    companion object {
        private const val HOME_SCREEN_START_DELAY: Long = 1000
    }

    private val handler by lazy(LazyThreadSafetyMode.NONE) { Handler(Looper.getMainLooper()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        showNextActivityDelayed()
    }

    private fun showNextActivityDelayed() = handler.postDelayed({ showNextActivity() }, HOME_SCREEN_START_DELAY)

    private fun showNextActivity() = if (Storage(this).isPasswordSaved()) startMainActivity() else startSignUpActivity()

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}
