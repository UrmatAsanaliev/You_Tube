package com.example.ru_tube.ui.fragment.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ru_tube.databinding.ItemPlayListBinding
import com.example.ru_tube.model.Item

class PlayListAdapter: RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    private val list:MutableList<Item> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(lst: List<Item>){
        this.list.clear()
        this.list.addAll(lst)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPlayListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(private val binding: ItemPlayListBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(item: Item){
                binding.txtPlayListName.text = item.snippet?.title
                binding.txtPlayListData.text = item.snippet?.publishedAt
                Glide.with(binding.imgPlayList)
                    .load(item.snippet?.thumbnails?.medium?.url)
                    .into(binding.imgPlayList)
            }

    }

}