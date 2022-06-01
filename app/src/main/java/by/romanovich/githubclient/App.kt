package by.romanovich.githubclient

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import by.romanovich.githubclient.di.appModule
import by.romanovich.githubclient.ui.utils.ViewModelStore
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext


class App : Application() {

    //val gitProjectsRepo: Repository by lazy { RepositoryImpl() }
    val viewModelStore by lazy { ViewModelStore() }

    //koin
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

}

//расширение
val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
