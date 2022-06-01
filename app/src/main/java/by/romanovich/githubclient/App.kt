package by.romanovich.githubclient

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import by.romanovich.githubclient.di.AppDependenciesComponent
import by.romanovich.githubclient.di.DaggerAppDependenciesComponent
import by.romanovich.githubclient.ui.utils.ViewModelStore



class App : Application() {

    //val gitProjectsRepo: Repository by lazy { RepositoryImpl() }
    val viewModelStore by lazy { ViewModelStore() }

    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()
            .build()
    }

   /* //koin
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }*/

}

//расширение
val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
