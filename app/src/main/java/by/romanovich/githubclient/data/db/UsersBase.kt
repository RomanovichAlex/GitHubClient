package by.romanovich.githubclient.data.db

import by.romanovich.githubclient.R
import by.romanovich.githubclient.domain.Title
import by.romanovich.githubclient.domain.User

open class UsersBase {


    val users: List<User> = listOf(
        User(Title("RomanovichAlex", 20, R.drawable.ic_user, listOf())),
        User(
            Title(
                "borhammere",
                20,
                R.drawable.ic_user,
                listOf("defunkt", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "wycats",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "ivey",
                20,
                R.drawable.ic_user,
                listOf("Work1", "Work2", "Work3", "Work4", "Work5", "Work6")
            )
        ),
        User(
            Title(
                "brynary",
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


