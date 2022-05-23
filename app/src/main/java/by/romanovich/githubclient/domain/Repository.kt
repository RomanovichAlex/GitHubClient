package by.romanovich.githubclient.domain

import io.reactivex.rxjava3.core.Single

interface Repository {

    fun getUserFromServer(name: String): Single<List<GitProjectEntity>>

    fun getUserFromLocalStorage(): List<User>

}

