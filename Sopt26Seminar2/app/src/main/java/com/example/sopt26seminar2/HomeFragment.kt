package com.example.sopt26seminar2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                    img_contents = "https://cdn.pixabay.com/photo/2020/04/07/17/01/chicks-5014152__340.jpg"
                ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}
