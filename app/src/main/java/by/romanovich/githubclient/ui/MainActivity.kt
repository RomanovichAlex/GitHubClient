package by.romanovich.githubclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.romanovich.githubclient.R
import by.romanovich.githubclient.databinding.ActivityMainBinding
import by.romanovich.githubclient.ui.listUsers.ListUsersFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, ListUsersFragment.newInstance())
            .commit()
    }
}