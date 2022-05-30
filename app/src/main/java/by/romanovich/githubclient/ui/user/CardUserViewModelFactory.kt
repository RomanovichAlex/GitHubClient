package by.romanovich.githubclient.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.romanovich.githubclient.domain.Repository


class CardUserViewModelFactory(private val id: String, private val repo: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CardUserViewModel(id, repo) as T
    }
}