package by.romanovich.githubclient.ui.listUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.romanovich.githubclient.AppState
import by.romanovich.githubclient.data.RepositoryImpl
import by.romanovich.githubclient.domain.Repository


class ListUsersViewModel : ViewModel(), UserContracts.ViewModelContract {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = RepositoryImpl()

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getUser() {
        liveDataToObserve.value = AppState.Loading

        Thread {
            Thread.sleep(1000)

            val user = repo.getUserFromLocalStorage()

            liveDataToObserve.postValue(AppState.Success(user))

        }.start()
    }

}