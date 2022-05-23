package by.romanovich.githubclient.data

import by.romanovich.githubclient.domain.entities.GitProjectEntity
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.domain.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RepositoryImpl : Repository, UsersBase() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getUserFromServer(name: String): Single<List<GitProjectEntity>> {
        return api.listRepos(name)

    }

    override fun getUserFromLocalStorage(): List<User> {
        return users
    }
}
