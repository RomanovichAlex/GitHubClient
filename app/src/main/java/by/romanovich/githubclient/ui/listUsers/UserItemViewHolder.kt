package by.romanovich.githubclient.ui.listUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.romanovich.githubclient.R
import by.romanovich.githubclient.data.User
import by.romanovich.githubclient.databinding.UsersItemLayoutBinding

class UserItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = UsersItemLayoutBinding.bind(view)

    companion object {
        @JvmStatic
        fun createView(parent: ViewGroup): UserItemViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.users_item_layout, parent, false)
            return UserItemViewHolder(view)
        }
    }

    fun bind(user: User, listener: (User) -> Unit) {
        binding.nameUserItemTextView.text = user.title.name
        binding.userItemImageView.setImageResource(user.title.image)
        binding.root.setOnClickListener {
            listener.invoke(user)
        }
    }
}