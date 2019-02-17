package aykuttasil.com.passnote.ui.main

import android.content.Context
import aykuttasil.com.passnote.di.ActivityContext
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

}
