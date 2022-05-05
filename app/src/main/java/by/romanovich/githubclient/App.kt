package by.romanovich.githubclient

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import by.romanovich.githubclient.data.RepositoryImpl
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.ui.utils.ViewModelStore


class App : Application() {
    val gitProjectsRepo: Repository by lazy { RepositoryImpl() }
    val viewModelStore by lazy { ViewModelStore() }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
