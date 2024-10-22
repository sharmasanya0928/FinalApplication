package com.example.finalapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R  // Updated the package reference
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Manually add 5 products
        val products: List<Entity> = manuallyAddedProducts

        // Initialize the adapter with the list of products and set it on the RecyclerView
        entityAdapter = EntityAdapter(products) { entity ->
            val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
            intent.putExtra("entity", entity) // Pass the selected product to the details screen
            startActivity(intent)
        }

        recyclerView.adapter = entityAdapter // Set adapter to RecyclerView
    }

    // Method to return manually added products (List of Entity)
    private val manuallyAddedProducts: List<Entity>
        get() {
            val products: MutableList<Entity> = ArrayList()

            // Add 5 example products with drawable resource IDs
            products.add(
                Entity(
                    "Gardening Toolset",
                    "55.20",
                    "This is a gardening toolset, including a spade, trowel, and pruners. The tools have wooden handles and metal heads, designed with a rustic yet modern aesthetic.",
                    R.drawable.product1
                )
            )
            products.add(
                Entity(
                    "Potted Plant",
                    "20.00",
                    "Vibrant potted plant with lush green leaves in a classic terracotta pot.",
                    R.drawable.product2
                )
            )
            products.add(
                Entity(
                    "Seed Packet",
                    "5.99",
                    "Gardening seed packet with colorful floral designs. The packet is labeled with seed type and planting instructions.",
                    R.drawable.product3
                )
            )
            products.add(
                Entity(
                    "Watering Can",
                    "9.99",
                    "A vintage metal watering can, painted in a soft pastel green with a long spout and sturdy handle.",
                    R.drawable.product4
                )
            )
            products.add(
                Entity(
                    "Gardening Gloves",
                    "8.00",
                    "A pair of durable gardening gloves with reinforced fingertips and a textured grip, presented in a green and beige color scheme. Perfect for handling plants and tools.",
                    R.drawable.product5
                )
            )

            return products
        }
}
