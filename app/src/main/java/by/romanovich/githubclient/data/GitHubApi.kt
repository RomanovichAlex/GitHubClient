package by.romanovich.githubclient.data

import by.romanovich.githubclient.domain.entities.GitProjectEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<GitProjectEntity>>
}