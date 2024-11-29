package com.example.rasanusa.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rasanusa.R
import com.example.rasanusa.data.response.DataItem
import com.example.rasanusa.ui.detail.DetailActivity
import org.w3c.dom.Text


class FoodAdapter(
    private var foodList: List<DataItem>, private val onItemClicked: (DataItem) -> Unit) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val itemData = foodList[position]
        Glide.with(holder.itemView.context)
            .load(itemData.image)
            .into(holder.imgPhoto)
        holder.name.text = itemData.name
        holder.asal.text = itemData.asal

        holder.itemView.setOnClickListener{
            onItemClicked(itemData)

        }

    }

    override fun getItemCount(): Int = foodList.size

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_food)
        val name: TextView = itemView. findViewById(R.id.txt_food_name)
        val asal: TextView = itemView.findViewById(R.id.txt_asal_daerah)

    }
}


//class FoodAdapter(private val listFood: List<FoodItem>,  private val onItemClick: (FoodItem) -> Unit) : RecyclerView.Adapter<FoodAdapter.ListViewHolder>() {
//
//    private var foodItems = listFood
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
//        return ListViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = foodItems.size
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val foodItem = foodItems[position]
//        holder.tvName.text = foodItem.name
//        holder.txtAsalDaerah.text = foodItem.asal
//
//        Glide.with(holder.itemView.context)
//            .load(foodItem.imageUrl)
//            .placeholder(R.drawable.ic_place_holder)
//            .into(holder.imgPhoto)
//
//        holder.itemView.setOnClickListener {
//            val intentToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
//            intentToDetail.putExtra(DetailActivity.FOOD_NAME, foodItem.name)
//            intentToDetail.putExtra(DetailActivity.FOOD_PHOTO, foodItem.imageUrl)
//            holder.itemView.context.startActivity(intentToDetail)
//        }
//    }
//
//    fun submitList(newList: List<FoodItem>) {
//        foodItems = newList
//        notifyDataSetChanged()
//    }
//
//    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_food)
//        val tvName: TextView = itemView.findViewById(R.id.txt_food_name)
//        val txtAsalDaerah: TextView = itemView.findViewById(R.id.txt_asal_daerah)
//    }
//}

//        private val imageView: ImageView = itemView.findViewById(R.id.iv_food)
//        private val nameText: TextView = itemView.findViewById(R.id.txt_food_name)
//        private val asalText: TextView = itemView.findViewById(R.id.txt_asal_daerah)
//
//        fun bind(foodItem: FoodItem) {
//            nameText.text = foodItem.name
//            asalText.text = foodItem.asal
//            Glide.with(itemView.context)
//                .load(foodItem.imageUrl)
//                .into(imageView)
//        }



