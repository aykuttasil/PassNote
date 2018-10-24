package aykuttasil.com.passnote.ui.main.pages.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.databinding.FragmentAboutBinding
import aykuttasil.com.passnote.di.Injectable
import aykuttasil.com.passnote.ui.common.BaseFragment
import aykuttasil.com.passnote.util.delegates.Inflate

class AboutFragment : BaseFragment(), Injectable {

    private val binding: FragmentAboutBinding by Inflate(R.layout.fragment_about)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }
}