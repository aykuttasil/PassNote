package aykuttasil.com.passnote.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import aykuttasil.com.passnote.di.key.ViewModelKey
import aykuttasil.com.passnote.ui.main.MainViewModel
import aykuttasil.com.passnote.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelBuilder {

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideDetailVieWModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(UserViewModel::class)
    abstract fun provideUserVieWModel(viewModel: UserViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

