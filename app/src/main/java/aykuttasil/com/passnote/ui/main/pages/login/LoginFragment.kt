package aykuttasil.com.passnote.ui.main.pages.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.databinding.FragmentLoginBinding
import aykuttasil.com.passnote.ui.common.BaseFragment
import aykuttasil.com.passnote.util.delegates.Inflate
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator

class LoginFragment : BaseFragment() {

    private val binding: FragmentLoginBinding by Inflate(R.layout.fragment_login)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun xyz() {

        val keygen = KeyGenerator.getInstance("AES")
        keygen.init(256)

        val cipher = Cipher.getInstance("RSA/ECB/OAEPPadding")

    }

}