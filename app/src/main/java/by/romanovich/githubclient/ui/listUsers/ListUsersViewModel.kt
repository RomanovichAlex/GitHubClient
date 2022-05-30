package by.romanovich.githubclient.ui.listUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.ui.utils.AppState
import by.romanovich.githubclient.ui.utils.BaseViewModel



class ListUsersViewModel(override val id: String, private val repository: Repository
) : ViewModel(), UserContracts.ViewModelContract, BaseViewModel {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = repository

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getUser() {
        liveDataToObserve.value = AppState.Loading

        Thread {
            val user = repo.getUserFromLocalStorage()
            liveDataToObserve.postValue(AppState.Success(user))
        }.start()
    }
}

/*class ListUsersViewModel(private val gitRepository: Repository
) : ViewModel() {

    //что бы закидывать объекты
    private val _repos = MutableLiveData<List<GitProjectEntity>>()
    //что бы читать объекты
    val repos: LiveData<List<GitProjectEntity>> = _repos

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> =_inProgress

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    //отметка вьюмодели
    fun onShowRepos(name: String) {
        _inProgress.postValue(true)
        compositeDisposable.add(
            gitRepository
                .getUserFromServer(name)
                //подписываемся
                .subscribeBy (
                    onSuccess =
                    {
                        _inProgress.postValue(false)
                        //берем лайв дату и передаем список
                        _repos.postValue(it)
                        //_error
                    },
                    onError={

                    })
        )
    }

    //метод отписки от всех
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}*/

