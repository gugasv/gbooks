package pirate.book.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pirate.book.R
import pirate.book.databinding.FragmentMainBinding
import pirate.book.ui.search.dialog.SearchDialogFragment

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var viewBinding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        navController = findNavController()

        setHasOptionsMenu(true)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.message.setOnClickListener({ view ->
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToSearchFragment())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
//                navController.navigate(MainFragmentDirections.actionMainFragmentToSearchFragment())
                SearchDialogFragment().show(parentFragmentManager, "searchDialog")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}