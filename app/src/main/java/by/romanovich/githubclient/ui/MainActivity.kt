package by.romanovich.githubclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.romanovich.githubclient.databinding.ActivityMainBinding
import by.romanovich.githubclient.domain.User
import by.romanovich.githubclient.ui.listUsers.ListUsersFragment
import by.romanovich.githubclient.ui.user.CardUserFragment


class MainActivity : AppCompatActivity(), ListUsersFragment.Controller {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val listUsersFragment: Fragment = ListUsersFragment()
            //для сохранения фрагмента и что бы не пересоздавался новый фрагмент(говорим что не нужно уничтожать фрагмент), вызовется онДестройвью но не вызовется онДестрой
            listUsersFragment.retainInstance = true
            supportFragmentManager.beginTransaction()
                .add(binding.mainContainer.id, listUsersFragment)
                .commit()
        }
    }

    override fun openScreen(user: User) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(
                binding.mainContainer.id,
                CardUserFragment.newInstance(user)
            )
            .commit()
    }
}