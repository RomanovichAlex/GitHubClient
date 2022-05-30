package by.romanovich.githubclient.ui.listUsers

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import by.romanovich.githubclient.R
import by.romanovich.githubclient.app
import by.romanovich.githubclient.databinding.ListUsersFragmentBinding
import by.romanovich.githubclient.domain.Repository
import by.romanovich.githubclient.domain.User
import by.romanovich.githubclient.ui.base.BaseFragment
import by.romanovich.githubclient.ui.utils.AppState
import org.koin.android.ext.android.inject
import java.util.*


class ListUsersFragment :
    BaseFragment<ListUsersFragmentBinding>(ListUsersFragmentBinding::inflate) {

    private val keyViewModelId = "key_view_model"
    private val adapter = UsersAdapter { user ->
        controller.openScreen(user)
    }
    private val repo: Repository by inject()

    private lateinit var viewModel: ListUsersViewModel
    private val controller by lazy { activity as Controller }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecyclerView.adapter = adapter

        if (savedInstanceState != null) {
            val viewModelId = savedInstanceState.getString(keyViewModelId) !!
            viewModel = app.viewModelStore.getViewModel(viewModelId) as ListUsersViewModel
        } else {
            val id = UUID.randomUUID().toString()
            viewModel = ListUsersViewModel(id,repo)
            app.viewModelStore.saveViewModel(viewModel)
        }

        viewModel.getData().observe(viewLifecycleOwner) { state ->
            render(state)
        }
        viewModel.getUser()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(keyViewModelId, viewModel.id)
    }

    private fun render(state: AppState) {

        when (state) {
            is AppState.Success<*> -> {

                val user: List<User> = state.data as List<User>
                adapter.setUser(user)
            }
            is AppState.Error -> {
                Toast.makeText(requireContext(), getString(R.string.error), Toast.LENGTH_SHORT)
                    .show()
            }
            is AppState.Loading -> {
                binding.usersRecyclerView.isVisible = true
            }
        }
    }

    interface Controller {
        fun openScreen(user: User)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity !is Controller) {
            throw IllegalStateException("Activity должна наследоваться от ColorListFragment.Controller")
        }
    }
}
