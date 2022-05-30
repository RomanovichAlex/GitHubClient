package by.romanovich.githubclient.ui.utils

import java.util.*


//WeakHashMap - имплемитация карты которая хранит слабые ссылки на ключи, не будет висеть в памяти
//для сохранения данных влюбом случае
class ViewModelStore {
    private val storage: MutableMap<String, BaseViewModel> = WeakHashMap()

    fun saveViewModel(viewModel: BaseViewModel) {
        storage[viewModel.id] = viewModel
    }

    fun getViewModel(id: String): BaseViewModel? {
        return storage[id]
    }
}



interface BaseViewModel {
    val id: String
}