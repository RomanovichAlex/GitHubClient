package com.example.retrofitrx.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.ui.user.CardUserViewModel


class ListUserViewModelFactory(private val id: String, private val repo: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CardUserViewModel(id, repo) as T
    }
}