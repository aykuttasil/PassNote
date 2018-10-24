package aykuttasil.com.passnote

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.multidex.MultiDex
import aykuttasil.com.passnote.di.AppInjector
import aykuttasil.com.passnote.util.Const
import aykuttasil.com.passnote.util.extension.debug
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import org.jetbrains.anko.notificationManager
import timber.log.Timber
import javax.inject.Inject


@SuppressLint("Registered")
open class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        initializeFabric()
        initNotificationChannel()

        debug {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initializeFabric() {
        val crashlyticsCore = CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build()

        val crashlytics = Crashlytics.Builder()
                .core(crashlyticsCore)
                .build()

        Fabric.with(this, crashlytics)
    }

    private fun initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(Const.NOTIF_CHANNEL_ID, Const.NOTIF_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
