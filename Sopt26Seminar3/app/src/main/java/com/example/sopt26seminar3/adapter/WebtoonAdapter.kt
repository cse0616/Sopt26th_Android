package com.example.sopt26seminar3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.data.WebtoonData
import com.example.sopt26seminar3.etc.WebtoonViewHolder

class WebtoonAdapter(private val context : Context) : RecyclerView.Adapter<WebtoonViewHolder>() {
    var datas = mutableListOf<WebtoonData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_webtoon,parent,false)
        return WebtoonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}