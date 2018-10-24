package aykuttasil.com.passnote.ui.main.pages.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aykuttasil.com.passnote.R
import aykuttasil.com.passnote.databinding.FragmentMainBinding
import aykuttasil.com.passnote.di.Injectable
import aykuttasil.com.passnote.ui.common.BaseSecureFragment
import aykuttasil.com.passnote.ui.notelist.NoteListActivity
import aykuttasil.com.passnote.util.delegates.Inflate
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainFragment : BaseSecureFragment(), Injectable {

    private val binding: FragmentMainBinding by Inflate(R.layout.fragment_main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNoteList.onClick {
            startActivity(Intent(getContext()?.applicationContext, NoteListActivity::class.java))
        }
    }
}