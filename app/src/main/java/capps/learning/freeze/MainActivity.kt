package capps.learning.freeze

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import capps.learning.freeze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categories : ArrayList<Category>
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categories = arrayListOf()
        val category1 = Category(R.drawable.ic_launcher_background, "Men")
        val category2 = Category(R.drawable.ic_launcher_background, "Women")
        val category3 = Category(R.drawable.ic_launcher_background, "Devices")
        val category4 = Category(R.drawable.ic_launcher_background, "Gadgets")
        val category5 = Category(R.drawable.ic_launcher_background, "Gaming")

        categories.add(category1)
        categories.add(category2)
        categories.add(category3)
        categories.add(category4)
        categories.add(category5)

        Log.d("MainActivity", "onCreate: ${categories.size}")
        categoryAdapter = CategoryAdapter(categories)

        binding.categoriesRecyclerview.adapter = categoryAdapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerview.layoutManager = linearLayoutManager
    }
}

/*
categories = categories.apply {
            plus(category1)
            plus(category2)
            plus(category3)
            plus(category4)
            plus(category5)
        }*/