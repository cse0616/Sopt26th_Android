package com.example.sopt26seminar3.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt26seminar3.R
import com.example.sopt26seminar3.adapter.WebtoonAdapter
import com.example.sopt26seminar3.data.WebtoonData
import kotlinx.android.synthetic.main.fragment_library.*

/**
 * A simple [Fragment] subclass.
 *
 */
class LibraryFragment : Fragment() {

    lateinit var webtoonAdapter: WebtoonAdapter
    var datas = mutableListOf<WebtoonData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webtoonAdapter = WebtoonAdapter(view.context)
        rv_mon.adapter = webtoonAdapter
        loadDatas()
    }

    private fun loadDatas(){
        datas.apply {
            add(
                WebtoonData(
                    id = 0,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "유미의 세포들",
                    star = 9.93,
                    author = "이동건"
                ))
            add(
                WebtoonData(
                    id = 1,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "복학왕",
                    star = 9.19,
                    author = "기안84"
                ))
            add(
                WebtoonData(
                    id = 2,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "연놈",
                    star = 9.92,
                    author = "상하"
                ))
            add(
                WebtoonData(
                    id = 3,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "고수",
                    star = 9.98,
                    author = "류기운 / 문정후"
                ))
            add(
                WebtoonData(
                    id = 4,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "헬퍼 2 : 킬베로스",
                    star = 9.90,
                    author = "삭"
                ))
            add(
                WebtoonData(
                    id = 5,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "세상은 돈과 권력",
                    star = 9.88,
                    author = "한동우 / 이도희"
                ))
            add(
                WebtoonData(
                    id = 6,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "그래서 나는 안티팬과 결혼했다",
                    star = 9.95,
                    author = "재림"
                ))
            add(
                WebtoonData(
                    id = 7,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "이츠마인",
                    star = 9.97,
                    author = "럭스"
                ))
            add(
                WebtoonData(
                    id = 8,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "여주실격!",
                    star = 9.96,
                    author = "기맹기"
                )
            )
            add(
                WebtoonData(
                    id = 0,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "유미의 세포들",
                    star = 9.93,
                    author = "이동건"
                ))
            add(
                WebtoonData(
                    id = 1,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "복학왕",
                    star = 9.19,
                    author = "기안84"
                ))
            add(
                WebtoonData(
                    id = 2,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "연놈",
                    star = 9.92,
                    author = "상하"
                ))
            add(
                WebtoonData(
                    id = 0,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "유미의 세포들",
                    star = 9.93,
                    author = "이동건"
                ))
            add(
                WebtoonData(
                    id = 1,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "복학왕",
                    star = 9.19,
                    author = "기안84"
                ))
            add(
                WebtoonData(
                    id = 2,
                    img_thumbnail = "https://cdn.pixabay.com/photo/2016/02/08/19/03/puppy-1187267_1280.jpg",
                    title = "연놈",
                    star = 9.92,
                    author = "상하"
                ))
        }
        webtoonAdapter.datas = datas
        webtoonAdapter.notifyDataSetChanged()
    }
}
