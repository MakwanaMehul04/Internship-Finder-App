package com.example.internshipfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internshipfinder.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val company = intent.getStringExtra("company")
        val location = intent.getStringExtra("location")
        val salary = intent.getStringExtra("salary")
        val experience = intent.getStringExtra("experience")
        val description = intent.getStringExtra("description")
        val skills = intent.getStringExtra("skills")
        val applyLink = intent.getStringExtra("applyLink")


        binding.titleTv.text = title
        binding.locationTv.text = location
        binding.experienceTv.text = experience
        binding.salaryTv.text = salary
        binding.companyTv.text = company
        binding.descriptionTv.text = description ?: "No description available"
//        binding.skillsTv.text = skills
//        binding.applyLinkTv.text = applyLink
    }
}