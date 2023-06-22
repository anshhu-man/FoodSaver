package com.example.foodsaver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodsaver.databinding.ActivityCartBinding

class CartActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_cart)
    }
}