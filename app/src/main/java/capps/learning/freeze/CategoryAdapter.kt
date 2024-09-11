package capps.learning.freeze

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import capps.learning.freeze.databinding.CategoryItemBinding

class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(private val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category){
            binding.name.text = category.text
            binding.image.setImageResource(category.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val categoryItemBinding = CategoryItemBinding.inflate(inflater)
        val categoryViewHolder = CategoryViewHolder(categoryItemBinding)

        return categoryViewHolder
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }
}