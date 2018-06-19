package aykuttasil.com.passnote.ui.user

import android.content.Context
import aykuttasil.com.passnote.di.ActivityContext
import dagger.Module
import dagger.Provides

/**
 * Created by aykutasil on 13.12.2017.
 */
@Module
class UserActivityModule {

    @ActivityContext
    @Provides
    fun providerContext(context: UserActivity): Context {
        return context
    }
}
