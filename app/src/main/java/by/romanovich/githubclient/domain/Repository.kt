package by.romanovich.githubclient.domain

interface Repository {
    fun getUserFromServer(): User

    fun getUserFromLocalStorage(): List<User>

    fun getWorksUsersFromLocalStorage(name: String): List<String>
}