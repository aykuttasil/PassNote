package aykuttasil.com.passnote.di

import aykuttasil.com.passnote.ui.main.pages.about.AboutFragment
import aykuttasil.com.passnote.ui.main.pages.main.MainFragment
import com.aykuttasil.sweetloc.di.scopes.PerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by aykutasil on 24.01.2018.
 */
@Module
abstract class FragmentBuilder {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindAboutFragment(): AboutFragment
}