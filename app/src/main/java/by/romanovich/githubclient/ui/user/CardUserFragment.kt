package by.romanovich.githubclient.ui.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import by.romanovich.githubclient.R
import by.romanovich.githubclient.app
import by.romanovich.githubclient.data.User
import by.romanovich.githubclient.databinding.CardUserFragmentBinding
import by.romanovich.githubclient.domain.GitProjectEntity
import by.romanovich.githubclient.ui.base.BaseFragment
import by.romanovich.githubclient.ui.utils.AppState
import java.util.*


class CardUserFragment : BaseFragment<CardUserFragmentBinding>(CardUserFragmentBinding::inflate) {

    private val keyViewModelId = "key_card_view_model"
    private val adapter = GitProjectsAdapter()
    private var name: String = ""

    private lateinit var viewModel: CardUserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<User>("USER")
        binding.nameUserTextView.text = user?.title?.name ?: ""
        user?.title?.image?.let { binding.userImageView.setImageResource(it) }

        binding.projectsRecyclerView.adapter = adapter

        if (savedInstanceState != null) {
            val viewModelId = savedInstanceState.getString(keyViewModelId)!!
            viewModel = app.viewModelStore.getViewModel(viewModelId) as CardUserViewModel
        } else {
            val id = UUID.randomUUID().toString()
            viewModel = CardUserViewModel(id)
            app.viewModelStore.saveViewModel(viewModel)
        }

        viewModel.getData().observe(viewLifecycleOwner) { state ->
            render(state)
        }
        name = user?.title?.name.toString()
        viewModel.getProjectsRetrofit(name)

    }

    private fun render(state: AppState) {

        when (state) {
            is AppState.Success<*> -> {

                val project: List<GitProjectEntity> = state.data as List<GitProjectEntity>
                adapter.setProject(project)
            }
            is AppState.Error -> {
                Toast.makeText(requireContext(), getString(R.string.error), Toast.LENGTH_SHORT)
                    .show()
            }
            is AppState.Loading -> {
                binding.cardViewContainer.isVisible = true
            }
        }

    }

    companion object {
        private const val USER_ARGS_KEY = "USER"
        fun newInstance(user: User) = CardUserFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(USER_ARGS_KEY, user)
        }
    }
}