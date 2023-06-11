package com.example.foodsaver

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class GetStartedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        findViewById<View>(R.id.get_started_txt).setOnClickListener {
            val loginIntent = Intent(this@GetStartedActivity, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }
    }
}
