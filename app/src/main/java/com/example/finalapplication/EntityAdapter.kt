package com.example.finalapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapplication.R

class EntityAdapter(private val entities: List<Entity>, private val listener: (Entity) -> Unit) :
    RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        // Get the current entity
        val entity = entities[position]

        // Bind the entity details
        holder.property1.text = entity.property1  // Set property1 text
        holder.property2.text = entity.property2  // Set property2 text

        // Bind the image from drawable resources
        holder.productImage.setImageResource(entity.imageResId) // Set image resource

        // Handle item click
        holder.itemView.setOnClickListener {
            listener(entity)  // Trigger the lambda passed from the activity
        }
    }

    override fun getItemCount(): Int {
        return entities.size
    }

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val property1: TextView = itemView.findViewById(R.id.property1)
        val property2: TextView = itemView.findViewById(R.id.property2)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
    }
}
