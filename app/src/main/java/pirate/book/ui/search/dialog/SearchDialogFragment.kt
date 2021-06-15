package pirate.book.ui.search.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import pirate.book.R
import pirate.book.databinding.FragmentSearchDialogBinding

class SearchDialogFragment: DialogFragment() {

    private lateinit var viewBinding: FragmentSearchDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchDialogBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun getTheme(): Int {
        return R.style.SearchDialog
    }

}