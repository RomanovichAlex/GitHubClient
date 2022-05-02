package by.romanovich.githubclient.data

import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.domain.User
import by.romanovich.githubclient.domain.getUsers
import by.romanovich.githubclient.domain.getWorksUser


class RepositoryImpl : Repository {
    override fun getUserFromServer(): User {
        return User()
    }

    override fun getUserFromLocalStorage(): List<User> {
        return getUsers()
    }

    override fun getWorksUsersFromLocalStorage(name: String): List<String> {
        return getWorksUser(name)
    }

}