package by.romanovich.githubclient.domain

import android.os.Parcelable
import by.romanovich.githubclient.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val title: Title = getDefaultTitle()
) : Parcelable

@Parcelize
data class Title(
    val name: String = "User",
    val id: Int = 0,
    val image: Int = R.drawable.ic_user,
    val works: List<String> = listOf("0", "0")
) : Parcelable

fun getDefaultTitle() = Title("User", 0, R.drawable.ic_user)

fun getUsers(): List<User> {
    return listOf(
        User(Title("User1", 0, R.drawable.ic_user, listOf())),
        User(
            Title(
                "User2",
                1,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User3",
                2,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User4",
                3,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User5",
                4,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User6",
                5,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User7",
                6,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User8",
                7,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User9",
                8,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User10",
                9,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User11",
                10,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User12",
                11,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
    )
}

fun getWorksUser(name: String): List<String> {
    val users: List<User> = getUsers()
    var worksUser: List<String> = listOf()

    for (i in 1 until users.size) {
        if (users[i].title.name == name) {
            worksUser = users[i].title.works
        }
    }
    return worksUser
}

