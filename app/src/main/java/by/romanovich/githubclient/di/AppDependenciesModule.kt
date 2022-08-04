package by.romanovich.githubclient.di


import by.romanovich.githubclient.data.retrofit.GitHubApi
import by.romanovich.githubclient.data.retrofit.RepositoryImpl
import by.romanovich.githubclient.domain.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppDependenciesModule {

    @Singleton
    @Provides
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi {
        return retrofit.create(GitHubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: GitHubApi): Repository {
        return RepositoryImpl(api)
    }

    @Provides
    fun provideBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()
    }
}






/*//val apiUrl = "https://api.github.com/"

val appModule = module {


    // single instance of HelloRepository
    single<String>(named("api_url")) { "https://api.github.com/" }
    single<Repository> { RepositoryImpl(get<GitHubApi>()) }
    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_url")))
            //упрощаем
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            //.addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    //каждый раз когда запрашивают мы возращаем новый конвертер
    factory<Converter.Factory> { GsonConverterFactory.create() }
    /*// Single presenter factory
    factory { MyViewModel(get()) }*/

}


/*private val apiUrl = "https://api.github.com/"
private val gsonConverter by lazy{ GsonConverterFactory.create()}
private val retrofit by lazy{ Retrofit.Builder()
    .baseUrl(apiUrl)
    //упрощаем
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    //.addConverterFactory(GsonConverterFactory.create())
    .addConverterFactory(gsonConverter)
    .build()
}
private val gitHubApi: GitHubApi = retrofit.create(GitHubApi::class.java)
val gitProjectsRepo: ProjectsRepo by lazy {
    RetrofitProjectsRepoImpl(gitHubApi) }
//val gitProjectsRepo: ProjectsRepo by lazy { RStringProjectsRepoImpl(this) }*/*/