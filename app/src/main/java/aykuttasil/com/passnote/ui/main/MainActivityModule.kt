package aykuttasil.com.passnote.ui.main

import android.content.Context
import aykuttasil.com.passnote.di.ActivityContext
import aykuttasil.com.passnote.ui.common.NavigationController
import dagger.Module
import dagger.Provides

/**
 * Created by aykutasil on 13.12.2017.
 */
@Module
class MainActivityModule {

    @ActivityContext
    @Provides
    fun providerContext(context: MainActivity): Context {
        return context
    }

    @ActivityContext
    @Provides
    fun providerNavigationController(mainActivity: MainActivity): NavigationController {
        return NavigationController(mainActivity)
    }
}
