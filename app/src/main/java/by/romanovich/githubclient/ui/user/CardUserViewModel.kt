package by.romanovich.githubclient.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.romanovich.githubclient.App
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.domain.entities.GitProjectEntity
import by.romanovich.githubclient.ui.utils.AppState
import by.romanovich.githubclient.ui.utils.BaseViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy


class CardUserViewModel(override val id: String, private val repository: Repository
) : ViewModel(), CardContracts.ViewModelContract, BaseViewModel {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = repository
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getData(): LiveData<AppState> = liveDataToObserve

    /*override fun getProjects(name: String) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            val project = repo.getUserFromServer(name)
            liveDataToObserve.postValue(AppState.Success(project))
        }.start()
    }*/

    override fun getProjectsRetrofit(name: String) {
        compositeDisposable.add(
            repo
                .getUserFromServer(name)
                .subscribeBy {
                    liveDataToObserve.postValue(AppState.Success(it))
                }
        )
    }

}