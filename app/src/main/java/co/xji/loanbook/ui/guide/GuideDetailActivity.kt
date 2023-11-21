package co.xji.loanbook.ui.guide

// GuideDetailActivity.kt
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import co.xji.loanbook.R

class GuideDetailActivity : AppCompatActivity() {

    private lateinit var tvGuideDetailTitle: TextView
    private lateinit var tvGuideDetailDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_detail)

        // 手动查找和初始化视图
        tvGuideDetailTitle = findViewById(R.id.tvGuideDetailTitle)
        tvGuideDetailDescription = findViewById(R.id.tvGuideDetailDescription)

        val title = intent.getStringExtra(EXTRA_GUIDE_TITLE)
        val description = intent.getStringExtra(EXTRA_GUIDE_DESCRIPTION)

        tvGuideDetailTitle.text = title
        tvGuideDetailDescription.text = description
    }

    companion object {
        const val EXTRA_GUIDE_TITLE = "extra_guide_title"
        const val EXTRA_GUIDE_DESCRIPTION = "extra_guide_description"
    }
}
