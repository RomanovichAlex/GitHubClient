package by.romanovich.githubclient.di

import by.romanovich.githubclient.ui.listUsers.ListUsersFragment
import by.romanovich.githubclient.ui.user.CardUserFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppDependenciesModule::class
    ]
)
interface AppDependenciesComponent {
    fun injectListUsers(listUserFragment: ListUsersFragment)
    fun injectUser(cardUserFragment: CardUserFragment)
}