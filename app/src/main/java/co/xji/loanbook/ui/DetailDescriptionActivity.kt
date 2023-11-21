package co.xji.loanbook.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import co.xji.loanbook.R

// DetailDescriptionActivity.kt
class DetailDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_description)

        val descriptionTextView: TextView = findViewById(R.id.detailDescriptionTextView)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        descriptionTextView.text = description
    }

    companion object {
        const val EXTRA_DESCRIPTION = "extra_description"
    }
}
