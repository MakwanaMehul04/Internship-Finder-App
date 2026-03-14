package com.example.internshipfinder

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipfinder.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var list =mutableListOf<InternshipModel>()
    private  var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.internshipRv.layoutManager = LinearLayoutManager(this)
        val adapter = InternshipAdapter(list)
        binding.internshipRv.adapter = adapter

        RetrofitInstance.api.getdata().enqueue(object : Callback<List<InternshipModel>> {

            override fun onResponse(
                call: Call<List<InternshipModel>>,
                response: Response<List<InternshipModel>>
            ) {

                if(response.isSuccessful){
                    val data = response.body()

                    if (data != null) {
                        list.clear()
                        list.addAll(data)
                        adapter.notifyDataSetChanged()
                    }
                }

            }

            override fun onFailure(call: Call<List<InternshipModel>>, t: Throwable) {
                println("Error: ${t.message}")
            }

        })
    }
}
