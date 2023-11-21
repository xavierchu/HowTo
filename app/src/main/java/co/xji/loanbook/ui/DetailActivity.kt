package co.xji.loanbook.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.xji.loanbook.R
import co.xji.loanbook.adapter.DetailAdapter
import co.xji.loanbook.model.DetailItem


// DetailActivity.kt
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 设置 Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerViewDetail: RecyclerView = findViewById(R.id.recyclerViewDetail)
        val detailAdapter = DetailAdapter(getSampleDetailItems())
        recyclerViewDetail.layoutManager = LinearLayoutManager(this)
        recyclerViewDetail.adapter = detailAdapter

        // 添加点击事件，启动 DetailDescriptionActivity
        detailAdapter.setOnItemClickListener { position ->
            val selectedDetailItem = detailAdapter.getItem(position)
            val intent = Intent(this, DetailDescriptionActivity::class.java)
            intent.putExtra(DetailDescriptionActivity.EXTRA_DESCRIPTION, selectedDetailItem.description)
            startActivity(intent)
        }
    }

    private fun getSampleDetailItems(): List<DetailItem> {
        // 返回示例数据，实际中可能从配置文件或网络获取
        return listOf(
            DetailItem(R.drawable.ic_icon_1, "Item 1"),
            DetailItem(R.drawable.ic_icon_2, "Item 2"),
            // 添加更多示例数据
        )
    }
}
