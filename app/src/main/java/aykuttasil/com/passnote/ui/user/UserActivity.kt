package aykuttasil.com.passnote.ui.user

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.databinding.ActivityUserBinding
import aykuttasil.com.passnote.di.ViewModelFactory
import aykuttasil.com.passnote.ui.common.BaseActivity
import aykuttasil.com.passnote.util.delegates.contentView
import aykuttasil.com.passnote.util.logd
import javax.inject.Inject


class UserActivity : BaseActivity() {

    private val binding: ActivityUserBinding by contentView(R.layout.activity_user)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logd { "oncreate" }
        viewModel = ViewModelProviders.of(this@UserActivity, viewModelFactory).get(UserViewModel::class.java)
    }
}
