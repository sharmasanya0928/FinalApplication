package com.example.finalapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalapplication.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve the Entity object passed from DashboardActivity
        val entity = intent.getSerializableExtra("entity") as? Entity

        entity?.let {
            // Use the entity's data to populate the UI
            val property1 = findViewById<TextView>(R.id.property1)
            val property2 = findViewById<TextView>(R.id.property2)
            val description = findViewById<TextView>(R.id.description)
            val productImage = findViewById<ImageView>(R.id.productImage)

            // Set the text fields with entity details
            property1.text = it.property1
            property2.text = it.property2
            description.text = it.description

            // Set the product image
            productImage.setImageResource(it.imageResId)
        } ?: run {
            // Handle the case where the entity is null
            Toast.makeText(this, "No entity data found", Toast.LENGTH_SHORT).show()
        }
    }
}
