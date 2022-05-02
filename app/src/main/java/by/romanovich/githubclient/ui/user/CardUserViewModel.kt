package by.romanovich.githubclient.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.romanovich.githubclient.AppState
import by.romanovich.githubclient.data.RepositoryImpl
import by.romanovich.githubclient.domain.Repository


class CardUserViewModel : ViewModel(), CardContracts.ViewModelContract {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = RepositoryImpl()

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getProjects(name: String) {
        liveDataToObserve.value = AppState.Loading
        val project = repo.getWorksUsersFromLocalStorage(name)
        liveDataToObserve.postValue(AppState.Success(project))
    }

}