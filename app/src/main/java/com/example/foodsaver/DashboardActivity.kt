package com.example.foodsaver

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class DashboardActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if (!isConnected(this)) {
            showInternetDialog()
        }

        tabLayout = findViewById(R.id.food_tab)
        viewPager = findViewById(R.id.food_viewpager)

        tabLayout.addTab(tabLayout.newTab().setText("Restaurants"))     //0
        tabLayout.addTab(tabLayout.newTab().setText("Grocery"))    //1
        tabLayout.addTab(tabLayout.newTab().setText("NGO"))    //2
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = FoodItemAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun showInternetDialog() {
        val dialog = Dialog(this)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val view = LayoutInflater.from(this).inflate(R.layout.no_internet_dialog, findViewById(R.id.no_internet_layout))
        view.findViewById<View>(R.id.try_again).setOnClickListener {
            if (!isConnected(this)) {
                showInternetDialog()
            } else {
                startActivity(Intent(applicationContext, DashboardActivity::class.java))
                finish()
            }
        }

        dialog.setContentView(view)
        dialog.show()
    }

    private fun isConnected(dashboardActivity: DashboardActivity): Boolean {
        val connectivityManager = dashboardActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

        return (wifiConn != null && wifiConn.isConnected) || (mobileConn != null && mobileConn.isConnected)
    }
}
