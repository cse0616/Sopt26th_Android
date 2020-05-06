package com.example.sopt26seminar2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_library.*

/**
 * A simple [Fragment] subclass.
 *
 */
class LibraryFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    var datas = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_library.adapter = instaAdapter  //리사이클러뷰의 어댑터를 instaAdapter로 지정
        rv_library.addItemDecoration(RecyclerViewItemDecoration()) //아이템 간격 조절
        rv_library.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL)) //구분선 추가
        loadDatas() //데이터를 임의로 생성하고 어댑터에 전달
    }

    private fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2020/03/31/19/20/dog-4988986_1280.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2015/10/01/20/28/animal-967657_1280.jpg"
                ))
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2020/01/31/07/53/cartoon-4807395__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2017/04/06/14/16/australian-shepherd-2208371_1280.jpg"
                ))
            add(
                InstaData(
                    userName = "전성은",
                    img_profile = "https://cdn.pixabay.com/photo/2020/04/12/11/19/squirrel-5033827__340.jpg",
                    img_contents = "https://cdn.pixabay.com/photo/2018/05/13/16/57/dog-3397110_1280.jpg"
                ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }

}
