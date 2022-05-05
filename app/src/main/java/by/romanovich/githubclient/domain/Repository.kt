package by.romanovich.githubclient.domain

import by.romanovich.githubclient.data.User
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getUserFromServer(name: String): Single<List<GitProjectEntity>>

    fun getUserFromLocalStorage(): List<User>

    fun getPojectsUsersFromLocalStorage(name: String): List<String>
}

