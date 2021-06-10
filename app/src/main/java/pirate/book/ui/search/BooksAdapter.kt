package pirate.book.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pirate.book.data.model.Book
import pirate.book.databinding.BookItemBinding

class BooksAdapter: ListAdapter<Book, BooksAdapter.BooksViewHolder>(BooksAdapterDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            BookItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = getItem(position)
        holder.bind(book)
    }

    class BooksViewHolder(private val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book) {
            binding.apply {
                book = item
            }
        }
    }

}

object BooksAdapterDiffCallback: DiffUtil.ItemCallback<Book>() {

    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

}