package com.example.foodsaver

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adiva.db.user
import com.example.foodsaver.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.apply {
            loginBtn.setOnClickListener {
                if(!TextUtils.isEmpty(emailTxt.text)){
                    if(!TextUtils.isEmpty(passwordTxt.text)){
                        loginUser()
                    }
                    else{
                        passwordTxt.error = "Enter Password"
                    }
                }
                else{
                    emailTxt.error = "Enter Email"
                }
                val intent = Intent(activity?.applicationContext,DashboardActivity::class.java)
                startActivity(intent)
            }
        }

        return binding.root
    }

    private fun loginUser() {
        binding.apply {
            val retrofit = RetrofitInstance.getRetrofitInstance()
            val api = retrofit.create(ApiInterface::class.java)

            val requestBody = ("{\"email\":\"${emailTxt.text.toString()}\"}").toRequestBody("application/json".toMediaTypeOrNull())

            val authorization = "Bearer pts_s6f5k4ph6wf6eyu5j2ix7yfqzb5juqre"

            val call = api.createUser(authorization,requestBody)
            call.enqueue(object : Callback<user> {
                override fun onResponse(call: Call<user>, response: Response<user>) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, response.body()?.summary, Toast.LENGTH_LONG).show()
                        if(response.body()?.status == "Success"){
                            val intent = Intent(activity?.applicationContext,DashboardActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            val intent = Intent(activity?.applicationContext,RegisterFragment::class.java)
                            startActivity(intent)
                        }
                    }
                }

                override fun onFailure(call: Call<user>, t: Throwable) {
                    Log.i("MYTAG","OnFailure : ${t.message}")
                }
            })
        }
    }
}