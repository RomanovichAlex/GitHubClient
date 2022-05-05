package by.romanovich.githubclient.ui.user

interface CardContracts {

    interface ViewModelContract {
        fun getProjects(name: String)
        fun getProjectsRetrofit(name: String)
    }

}