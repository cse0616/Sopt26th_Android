package com.example.sopt26seminar3.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.adapter.InstaAdapter
import com.example.sopt26seminar3.data.InstaData
import com.example.sopt26seminar3.etc.RecyclerViewItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    var datas = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter  //리사이클러뷰의 어댑터를 instaAdapter로 지정
        rv_home.addItemDecoration(RecyclerViewItemDecoration()) //아이템 간격 조절
        rv_home.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL)) //구분선 추가
        loadDatas() //데이터를 임의로 생성하고 어댑터에 전달
    }

    private fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2020/04/27/09/21/cat-5098930__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2020/04/25/15/26/cat-5091286__340.jpg"
                ))
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2020/01/31/07/53/cartoon-4807395__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2014/08/08/21/02/iceland-413700__340.jpg"
                ))
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2020/04/12/11/19/squirrel-5033827__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2018/10/01/09/21/pets-3715733_1280.jpg"
                ))
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2016/01/11/22/38/animal-1134504_1280.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2019/08/19/07/45/pets-4415649_1280.jpg"
                ))
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2019/02/06/15/18/puppy-3979350_1280.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2018/05/11/08/11/pet-3389729_960_720.jpg"
                ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}

