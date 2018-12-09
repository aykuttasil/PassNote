package aykuttasil.com.passnote.di.components

import android.app.Application
import aykuttasil.com.passnote.App
import aykuttasil.com.passnote.di.ActivityBuilder
import aykuttasil.com.passnote.di.ServiceBuilder
import aykuttasil.com.passnote.di.modules.AppModule
import aykuttasil.com.passnote.di.modules.DatabaseModule
import aykuttasil.com.passnote.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (ActivityBuilder::class),
    (ServiceBuilder::class),
    (AppModule::class),
    (NetworkModule::class),
    (DatabaseModule::class)
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
}
