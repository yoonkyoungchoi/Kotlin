package kr.hs.emirim.project10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.title="명화 선호도 투표"

        var voteCount = IntArray(9)
        for(i in 1..9)
            voteCount[i] = 0
        var image = arrayOfNulls<ImageView>(9)
        var imageId = arrayOf(R.id.iv1, iv2, iv3, iv4, iv5,iv6,iv6,iv7,iv8,iv9)
        var imgName = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
        "이레느깡 단 베르냥", "잠자는 소녀", "테라스의 두 자매", "피아노 래슨", "피아노 앞 소녀들")

        for (i in imageId.indices){
            image[i] = image[i]
            image[i]?.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + "총 " + voteCount[i] + "표", Toast.LENGTH_LONG).show()
            }
        }

        btnResult.setOnClickListener {
            var intent1 = Intent(application, ResultActivity::class.java)
            intent1.putExtra("VoteCount", voteCount)
            intent1.putExtra("ImageName",imgName )
            this.startActivity(intent1)
        }
    }
}