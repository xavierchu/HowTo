package co.xji.loanbook.ui

// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.xji.loanbook.R
import co.xji.loanbook.adapter.HowToDoAdapter
import co.xji.loanbook.adapter.guide.GuideAdapter
import co.xji.loanbook.model.HowToDoItem
import co.xji.loanbook.ui.guide.GuideDetailActivity
import co.xji.loanbook.model.guide.GuideModel

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewHowToDo: RecyclerView = findViewById(R.id.recyclerViewHowToDo)
        val howToDoAdapter = HowToDoAdapter(getSampleHowToDoItems())
        recyclerViewHowToDo.layoutManager = LinearLayoutManager(this)
        recyclerViewHowToDo.adapter = howToDoAdapter

        // 设置点击事件
        howToDoAdapter.setOnItemClickListener { position ->
            // 处理点击事件，可以打印日志或者进行其他操作
            Log.d("MainActivity", "Item clicked at position $position")
            // 启动 DetailActivity
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getSampleHowToDoItems(): List<HowToDoItem> {
        // 返回示例数据，实际中可能从配置文件或网络获取
        return listOf(
            HowToDoItem(R.drawable.ic_background_1, "How to do sth1"),
            HowToDoItem(R.drawable.ic_background_2, "How to do sth2"),
            // 添加更多示例数据
        )
    }
}
