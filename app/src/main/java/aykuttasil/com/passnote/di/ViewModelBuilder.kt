package aykuttasil.com.passnote.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
    abstract fun provideMainVieWModel(viewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(UserViewModel::class)
    abstract fun provideUserVieWModel(viewModel: UserViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

