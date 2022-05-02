package by.romanovich.githubclient.ui.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import by.romanovich.githubclient.AppState
import by.romanovich.githubclient.R
import by.romanovich.githubclient.databinding.CardUserFragmentBinding
import by.romanovich.githubclient.domain.User
import by.romanovich.githubclient.ui.base.BaseFragment


class CardUserFragment : BaseFragment<CardUserFragmentBinding>(CardUserFragmentBinding::inflate) {

    private val adapter = GitProjectsAdapter()
    private var name: String = ""

    private lateinit var viewModel: CardUserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<User>("USER")
        binding.nameUserTextView.text = user?.title?.name ?: ""
        user?.title?.image?.let { binding.userImageView.setImageResource(it) }

        binding.projectsRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(CardUserViewModel::class.java)

        viewModel.getData().observe(viewLifecycleOwner) { state ->
            render(state)
        }
        name = user?.title?.name.toString()
        viewModel.getProjects(name)

    }

    private fun render(state: AppState) {

        when (state) {
            is AppState.Success<*> -> {

                val project: List<String> = state.data as List<String>
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
        fun newInstance(bundle: Bundle?): CardUserFragment {
            val fragment = CardUserFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}