package com.example.internshipfinder

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipfinder.databinding.ItemInternshipBinding

class InternshipAdapter(private val list: List<InternshipModel>) :
    RecyclerView.Adapter<InternshipAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemInternshipBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InternshipAdapter.ViewHolder {
        val binding =
            ItemInternshipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InternshipAdapter.ViewHolder, position: Int) {
        val model = list[position]


        holder.binding.titleTv.text = model.title
        holder.binding.companyTv.text = model.company
        holder.binding.locationTv.text = model.location

        holder.binding.applyBtn.setOnClickListener {

            val context = holder.itemView.context
            val intent = Intent(context, DetailsActivity::class.java)

            intent.putExtra("title",model.title)
            intent.putExtra("company",model.company)
            intent.putExtra("location",model.location)
            intent.putExtra("experience",model.experience)
            intent.putExtra("salary",model.salary)
            intent.putExtra("description",model.description)
            intent.putExtra("skills",model.skills)
            intent.putExtra("applyLink",model.applyLink)

            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}