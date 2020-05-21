package com.example.sopt26seminar3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt26seminar3.etc.InstaViewHolder
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.data.InstaData

class InstaAdapter(private val context : Context) : RecyclerView.Adapter<InstaViewHolder>() {
    var datas = mutableListOf<InstaData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_insta,parent,false)
        return InstaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}