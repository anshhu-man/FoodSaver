package com.example.foodsaver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodsaver.db.FoodDomain

class FoodsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var list: MutableList<FoodDomain>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_foods, container, false)

        list = mutableListOf(
            FoodDomain(R.drawable.food_img_1, "Peperoni Pizza", "Rs. 149.00",0),
            FoodDomain(R.drawable.food_img_2, "Cheese Burger", "Rs. 49.00",0),
            FoodDomain(R.drawable.food_img_1, "Paneer Pizza", "Rs. 99.00",0),
            FoodDomain(R.drawable.food_img_2, "French Fries", "Rs. 79.00",0),
            FoodDomain(R.drawable.food_img_1, "Masala Dosa", "Rs. 59.00",0),
            FoodDomain(R.drawable.food_img_2, "Fried Rice", "Rs. 129.00",0),
            FoodDomain(R.drawable.food_img_1, "Dum Biryani", "Rs. 189.00",0),
            FoodDomain(R.drawable.food_img_2, "Veg. Biryani", "Rs. 159.00",0),
            FoodDomain(R.drawable.food_img_1, "Fried Chicken", "Rs. 119.00",0),
            FoodDomain(R.drawable.food_img_2, "Chicken Soup", "Rs. 199.00",0),
            FoodDomain(R.drawable.food_img_2, "Veg. Momo", "Rs. 59.00",0)
        )

        recyclerView = view.findViewById(R.id.food_recycler)
        foodAdapter = FoodAdapter(list, requireActivity().applicationContext)
        val manager = LinearLayoutManager(requireActivity().applicationContext, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = foodAdapter

        return view
    }
}
