package by.romanovich.githubclient.ui.listUsers

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import by.romanovich.githubclient.AppState
import by.romanovich.githubclient.R
import by.romanovich.githubclient.databinding.ListUsersFragmentBinding
import by.romanovich.githubclient.domain.User
import by.romanovich.githubclient.ui.base.BaseFragment
import by.romanovich.githubclient.ui.user.CardUserFragment


class ListUsersFragment :
    BaseFragment<ListUsersFragmentBinding>(ListUsersFragmentBinding::inflate) {

    private val adapter = UsersAdapter()

    private lateinit var viewModel: ListUsersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecyclerView.adapter = adapter



        adapter.listener = UsersAdapter.OnItemClick { user ->
            val bundle = Bundle()
            bundle.putParcelable("USER", user)

            activity?.supportFragmentManager?.apply {
                beginTransaction()
                    .replace(R.id.main_container, CardUserFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commit()
            }
        }

        viewModel = ViewModelProvider(this).get(ListUsersViewModel::class.java)

        viewModel.getData().observe(viewLifecycleOwner) { state ->
            render(state)
        }

        viewModel.getUser()

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

    companion object {
        fun newInstance() = ListUsersFragment()
    }

}
