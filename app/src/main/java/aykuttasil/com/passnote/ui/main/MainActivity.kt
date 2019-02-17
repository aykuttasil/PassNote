package aykuttasil.com.passnote.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.di.ViewModelFactory
import aykuttasil.com.passnote.ui.common.BaseActivity
import aykuttasil.com.passnote.util.logd
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }
}
