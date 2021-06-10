package pirate.book.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pirate.book.databinding.FragmentBookBinding

@AndroidEntryPoint
class BookFragment: Fragment() {

    private val viewModel: BookViewModel by viewModels()

    private lateinit var viewBinding: FragmentBookBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBookBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

}