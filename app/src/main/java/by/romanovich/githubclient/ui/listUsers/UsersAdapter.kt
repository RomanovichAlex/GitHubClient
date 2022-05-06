package by.romanovich.githubclient.ui.listUsers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.romanovich.githubclient.domain.User


class UsersAdapter(
    private val itemClickCallback: (User) -> Unit
) : RecyclerView.Adapter<UserItemViewHolder>() {

    private var user: List<User> = listOf()

    fun setUser(data: List<User>) {
        user = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserItemViewHolder.createView(parent)

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickCallback)
    }

    private fun getItem(pos: Int) = user[pos]

    override fun getItemCount(): Int = user.size

}
