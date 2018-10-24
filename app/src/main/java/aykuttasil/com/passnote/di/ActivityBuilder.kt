package aykuttasil.com.passnote.di

import aykuttasil.com.passnote.ui.addnote.AddNoteActivity
import aykuttasil.com.passnote.ui.main.MainActivity
import aykuttasil.com.passnote.ui.main.MainActivityModule
import aykuttasil.com.passnote.ui.signup.SignUpActivity
import aykuttasil.com.passnote.ui.splash.SplashActivity
import aykuttasil.com.passnote.ui.user.UserActivity
import aykuttasil.com.passnote.ui.user.UserActivityModule
import com.aykuttasil.sweetloc.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by aykutasil on 13.12.2017.
 */
@Module(includes = [FragmentBuilder::class])
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun bindMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindSignUpActivity(): SignUpActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindAddNoteActivity(): AddNoteActivity


    @PerActivity
    @ContributesAndroidInjector(modules = [(UserActivityModule::class)])
    internal abstract fun bindUserActivity(): UserActivity

}