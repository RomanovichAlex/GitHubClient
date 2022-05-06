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

fun getDefaultTitle() = Title("User", 20, R.drawable.ic_user)