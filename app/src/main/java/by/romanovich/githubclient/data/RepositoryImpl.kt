package by.romanovich.githubclient.data

import by.romanovich.githubclient.data.db.UsersBase
import by.romanovich.githubclient.data.retrofit.GitHubApi
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.domain.User
import by.romanovich.githubclient.domain.entities.GitProjectEntity
import io.reactivex.rxjava3.core.Single


class RepositoryImpl(private val api: GitHubApi) : Repository {

    override fun getUserFromServer(name: String): Single<List<GitProjectEntity>> {
        return api.listRepos(name)

    }

    override fun getUserFromLocalStorage(): List<User> {
        return UsersBase().users
    }
}
