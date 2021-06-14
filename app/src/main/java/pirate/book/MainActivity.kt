package pirate.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import dagger.hilt.android.AndroidEntryPoint
import pirate.book.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}