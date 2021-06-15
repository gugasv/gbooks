package pirate.book.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import pirate.book.databinding.FragmentSearchBinding

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var viewBinding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchBinding.inflate(inflater, container, false)

        val adapter = BooksAdapter()
        viewBinding.list.adapter = adapter
        viewBinding.list.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        viewModel.books.observe(viewLifecycleOwner) { books ->
            adapter.submitList(books)
        }

        return viewBinding.root
    }

}