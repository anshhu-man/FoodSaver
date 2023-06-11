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
import com.example.foodsaver.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.apply {
            registerBtn.setOnClickListener {
                if(!TextUtils.isEmpty(firstNameTxt.text)){
                    if(!TextUtils.isEmpty(lastNameTxt.text)){
                        if(!TextUtils.isEmpty(emailTxt.text)){
                            if(!TextUtils.isEmpty(passwordTxt.text)){
                                if(confirmPassword.text.toString() == passwordTxt.text.toString()){
                                    registerUser();
                                }
                                else{
                                    confirmPassword.error = "Passwords not matching"
                                }
                            }
                            else{
                                passwordTxt.error = "Enter Password"
                            }
                        }
                        else{
                            emailTxt.error = "Enter Email"
                        }
                    }
                    else{
                        lastNameTxt.error = "Enter Name"
                    }
                }
                else{
                    firstNameTxt.error = "Enter Name"
                }
            }
        }
        return binding.root
    }

    private fun registerUser() {
        binding.apply {
            val retrofit = RetrofitInstance.getRetrofitInstance()
            val api = retrofit.create(ApiInterface::class.java)

            val requestBody = ("{\"email\":\"${emailTxt.text.toString()}\"," +
                    "\"id_provider\":\"password\"," +
                    "\"authenticator\":\"${ passwordTxt.text.toString()}\"" +
                    ",\"profile\":{\"first_name\":\"${firstNameTxt.text.toString()}\",\"last_name\":\"${lastNameTxt.text.toString()}\"}}")
                .toRequestBody("application/json".toMediaTypeOrNull())

            val authorization = "Bearer pts_s6f5k4ph6wf6eyu5j2ix7yfqzb5juqre"

            val call = api.createUser(authorization,requestBody)
            call.enqueue(object : Callback<user> {
                override fun onResponse(call: Call<user>, response: Response<user>) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, response.body()?.summary,Toast.LENGTH_LONG).show()
                        if(response.body()?.status == "Success"){
                            val intent = Intent(activity?.applicationContext,DashboardActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            val intent = Intent(activity?.applicationContext,LoginFragment::class.java)
                            startActivity(intent)
                        }
                    } else {
                        // User creation failed
                        Log.i("MYTAG","OnResponseFail : "+response.errorBody())
                        val snackbar = Snackbar.make(binding.root,"Password must have lower case, upper case & special characters, 8 characters long",Snackbar.LENGTH_LONG)
                        snackbar.show();
                    }
                }

                override fun onFailure(call: Call<user>, t: Throwable) {
                    Log.i("MYTAG","OnFailure : ${t.message}")
                }
            })
        }
    }
}