package com.victorojeda.restaurantfinder.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.victorojeda.restaurantfinder.R
import com.victorojeda.restaurantfinder.model.Business

class BusinessAdapter(var businesses: List<Business>) : RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_business, parent, false)
        return BusinessViewHolder(view)
    }

    override fun getItemCount(): Int {
        return businesses.size
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val business = businesses[position]
        holder.bind(business)
    }

    class BusinessViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var business: Business
        private val businessImage: ImageView = itemView.findViewById(R.id.image_business)
        private val nameTextView: TextView = itemView.findViewById(R.id.text_name)

        fun bind(business: Business) {
            this.business = business
            nameTextView.text = business.name
            businessImage.load(business.photoUrl)
        }
    }
}