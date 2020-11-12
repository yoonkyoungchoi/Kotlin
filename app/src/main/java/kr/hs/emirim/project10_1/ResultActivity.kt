package kr.hs.emirim.project10_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import java.util.Collections.max
import kotlin.math.max

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.title = "투표 결과"

        var intent1 = this.getIntent()
        var voteResult = intent1.getIntArrayExtra("VoteCount")
        var imageName = intent1.getStringArrayExtra("ImageName")
        var text = arrayOf(text1, text2, text3, text4,text5,text6,text7, text8, text9)
        var rbarArr = arrayOf(rbar1, rbar2, rbar3, rbar4, rbar5, rbar6, rbar7, rbar8, rbar9)

        var max = 0
        var imageFileArr = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,R.drawable.pic5,R.drawable.pic6
                ,R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)
        for (i in voteResult!!.indices) {
            if (voteResult[max] < voteResult[i])
                max = i
        }

        textTop.text = imageName!![max]
        imageTop.setImageResource(imageFileArr[max])

        for (i in voteResult!!.indices){
            text[i].setText(imageName!!.get(i))
            rbarArr[i].rating = voteResult[i].toFloat()
        }

        btnReturn.setOnClickListener {
            this.finish()
        }

    }
}