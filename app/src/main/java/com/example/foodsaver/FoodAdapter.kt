package com.example.foodsaver

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(
    private val list: List<FoodItemModel>,
    private val context: Context
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item_layout, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = list[position]
        holder.food_image.setImageResource(foodItem.food_image)
        holder.food_name.text = foodItem.food_name
        holder.food_price.text = foodItem.food_price
        holder.view.setOnClickListener {
            val intent = Intent(context, FoodDetailActivity::class.java)
            intent.putExtra("food_name", foodItem.food_name)
            intent.putExtra("food_price", foodItem.food_price)
            intent.putExtra("food_image", foodItem.food_image)
            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val food_image: ImageView = itemView.findViewById(R.id.food_image)
        val food_name: TextView = itemView.findViewById(R.id.food_name)
        val food_price: TextView = itemView.findViewById(R.id.food_price)
        val view: View = itemView

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val foodItem = list[position]
                    val intent = Intent(context, FoodDetailActivity::class.java).apply {
                        putExtra("food_name", foodItem.food_name)
                        putExtra("food_price", foodItem.food_price)
                        putExtra("food_image", foodItem.food_image)
                    }
                    view.context.startActivity(intent)
                }
            }
        }
    }
}
