package com.example.foodsaver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var list: MutableList<FoodItemModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_foods, container, false)

        list = mutableListOf(
            FoodItemModel(R.drawable.food_img_1, "Food name 1", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_2, "Food name 2", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_1, "Food name 3", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_2, "Food name 4", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_1, "Food name 5", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_2, "Food name 6", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_1, "Food name 7", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_2, "Food name 8", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_1, "Food name 9", "Rs: Food price"),
            FoodItemModel(R.drawable.food_img_2, "Food name 10", "Rs: Food price")
        )

        recyclerView = view.findViewById(R.id.food_recycler)
        foodAdapter = FoodAdapter(list, requireActivity().applicationContext)
        val manager = LinearLayoutManager(requireActivity().applicationContext, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = foodAdapter

        return view
    }
}
