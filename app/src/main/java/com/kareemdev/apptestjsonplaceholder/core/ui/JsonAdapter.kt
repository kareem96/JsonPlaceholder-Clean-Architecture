package com.kareemdev.apptestjsonplaceholder.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kareemdev.apptestjsonplaceholder.R
import com.kareemdev.apptestjsonplaceholder.core.domain.model.Json
import com.kareemdev.apptestjsonplaceholder.databinding.ItemListJsonBinding

class JsonAdapter : RecyclerView.Adapter<JsonAdapter.ListViewHolder>() {
    private val listData = ArrayList<Json>()
    var onItemClick: ((Json) -> Unit)? = null

    fun setData(newListData: List<Json>?){
        if(newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemListJsonBinding.bind(itemView)
        fun bind(data: Json){
            with(binding){
                tvItemTitle.text = data.title
            }
        }
        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_json, parent, false))


    override fun onBindViewHolder(holder: JsonAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount()= listData.size
}