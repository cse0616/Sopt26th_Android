package com.example.sopt26seminar2

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        //짝수번째 아이템은 좌우 간격, 홀수번째 아이템은 상하 간격을 줌
        if(position % 2 != 0){
            outRect.left = 30
            outRect.right = 30
        }else{
            outRect.top = 30
            outRect.bottom = 30
        }
    }
}