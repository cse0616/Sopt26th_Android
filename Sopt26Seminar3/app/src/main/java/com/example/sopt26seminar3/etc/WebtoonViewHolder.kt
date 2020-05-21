package com.example.sopt26seminar3.etc

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.data.WebtoonData

class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_thumbnail = itemView.findViewById<ImageView>(R.id.img_rv_thumbnail)
    val tv_title = itemView.findViewById<TextView>(R.id.txt_rv_title)
    val tv_star = itemView.findViewById<TextView>(R.id.txt_rv_star)
    val tv_author = itemView.findViewById<TextView>(R.id.txt_rv_author)

    fun bind(webtoonData: WebtoonData){
        Glide.with(itemView).load(webtoonData.img_thumbnail).into(img_thumbnail)
        tv_title.text = webtoonData.title
        tv_star.text = "★" + webtoonData.star.toString()
        tv_author.text = webtoonData.author
    }
}