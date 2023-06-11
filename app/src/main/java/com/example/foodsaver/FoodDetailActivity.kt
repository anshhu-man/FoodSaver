package com.example.foodsaver

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FoodDetailActivity : AppCompatActivity() {

    private lateinit var food_back: ImageView
    private lateinit var food_name: TextView
    private lateinit var food_price: TextView
    private lateinit var food_image: ImageView
    private lateinit var ordernow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        food_back = findViewById(R.id.food_back)
        food_back.setOnClickListener { onBackPressed() }


        food_name = findViewById(R.id.food_name)
        food_price = findViewById(R.id.food_price)
        food_image = findViewById(R.id.food_image)

        food_name.text = intent.getStringExtra("food_name")
        food_price.text = intent.getStringExtra("food_price")
        food_image.setImageResource(intent.getIntExtra("food_image", R.drawable.food_img_1))

        ordernow = findViewById(R.id.food_order)
        ordernow.setOnClickListener {
            val orderFood = Intent(this,CartActivity::class.java)
            startActivity(orderFood)
        }
    }
}
