package by.romanovich.githubclient.domain

import by.romanovich.githubclient.domain.entities.GitProjectEntity
import io.reactivex.rxjava3.core.Single

interface Repository {

    // C(R)UD получение списка проектов по юзеру
    fun getUserFromServer(name: String): Single<List<GitProjectEntity>>

    fun getUserFromLocalStorage(): List<User>

}

