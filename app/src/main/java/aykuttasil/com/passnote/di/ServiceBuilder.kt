package aykuttasil.com.passnote.di

import aykuttasil.com.passnote.di.scopes.PerService
import aykuttasil.com.passnote.service.AppService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilder {

    @PerService
    @ContributesAndroidInjector
    internal abstract fun bindAppService(): AppService

}