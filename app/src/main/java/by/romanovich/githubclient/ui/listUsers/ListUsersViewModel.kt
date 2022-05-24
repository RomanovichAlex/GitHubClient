package by.romanovich.githubclient.ui.listUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.romanovich.githubclient.App
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.ui.utils.AppState
import by.romanovich.githubclient.ui.utils.BaseViewModel


class ListUsersViewModel(override val id: String) : ViewModel(), UserContracts.ViewModelContract,
    BaseViewModel {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = App().gitProjectsRepo

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getUser() {
        liveDataToObserve.value = AppState.Loading

        Thread {
            val user = repo.getUserFromLocalStorage()
            liveDataToObserve.postValue(AppState.Success(user))
        }.start()
    }
}