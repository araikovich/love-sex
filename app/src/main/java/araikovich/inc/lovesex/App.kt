package araikovich.inc.lovesex

import android.app.Application
import araikovich.inc.lovesex.di.localProviderModule
import araikovich.inc.lovesex.di.useCaseModule
import araikovich.inc.lovesex.di.viewModelModule
import org.koin.android.ext.koin.androidContext

class App : Application() {

    companion object {

        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule, useCaseModule, localProviderModule
                )
            )
        }
    }
}