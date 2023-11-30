package com.example.aeontz.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aeontz.data.remote.model.Response
import com.example.aeontz.databinding.ItemLayoutBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Response){
            with(binding){
                itemId.text = "ID: ${item.id}"
                itemTitle.text = "Title: ${item.title}"
                if (item.amount == null) itemAmount.text = "Amount: нет значения" else itemAmount.text = "Amount: ${item.amount}"
//                itemAmount.text = "Amount: ${item.amount}"
                if (item.created == null) itemCreated.text = "Created: нет значения" else itemCreated.text = "Created: ${item.created}"

//                itemCreated.text = "Created: ${item.created}"
            }
        }
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<Response>(){
            override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean {
                return oldItem == newItem
            }
        }
    var differ = AsyncListDiffer(this, differCallback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainAdapter.MainViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.bind(currentItem)
    }
}