package by.romanovich.githubclient.data

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

fun getDefaultTitle() = Title("User", 20, R.drawable.ic_user)

fun getUsers(): List<User> {
    return listOf(
        User(Title("RomanovichAlex", 20, R.drawable.ic_user, listOf())),
        User(
            Title(
                "borhammere",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User3",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User4",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User5",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User6",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User7",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User8",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User9",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User10",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User11",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "User12",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        )
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

