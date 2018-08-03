package aykuttasil.com.passnote.ui.main

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.bottomnavigation.BottomNavigationView
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.databinding.ActivityMainBinding
import aykuttasil.com.passnote.di.ViewModelFactory
import aykuttasil.com.passnote.ui.common.BaseActivity
import aykuttasil.com.passnote.ui.common.NavigationController
import aykuttasil.com.passnote.ui.common.RetryCallback
import aykuttasil.com.passnote.util.NewMessageNotification
import aykuttasil.com.passnote.util.delegates.contentView
import aykuttasil.com.passnote.util.load
import aykuttasil.com.passnote.util.logd
import aykuttasil.com.passnote.util.then
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.delay
import javax.inject.Inject


class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var navigationController: NavigationController

    private lateinit var mainViewModel: MainViewModel

    companion object {
        private const val KEY_IMAGE_URI = "imageUri"
        private const val IMAGE_PICK_REQUEST = 101
    }

    private var imageUri: Uri? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.getUser("aykuttasillll").observe(this, Observer {
            binding.user = it?.data
            binding.resource = it
            binding.callback = object : RetryCallback {
                override fun retry() {
                    mainViewModel.retryGetUser("aykuttasil")
                }

            }
            binding.executePendingBindings()
        })
    }

}
