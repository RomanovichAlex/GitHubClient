package by.romanovich.githubclient.data.mockDb


import by.romanovich.githubclient.domain.entities.GitProjectEntity
import io.reactivex.rxjava3.core.Single

class MockUsersBase {

    fun observeReposForUser(name: String): Single<List<GitProjectEntity>> {
        val dummyList = listOf(
            GitProjectEntity(0, "!!!"),
            GitProjectEntity(1, "Ololo"),
            GitProjectEntity(2, "Fljenfljwnfe"),
            GitProjectEntity(3, "wevlkwnev"),
            GitProjectEntity(4, "otmknm"),
            GitProjectEntity(5, "dflkbm;slmfbv"),
        )

        return Single.just(dummyList)
    }
}
