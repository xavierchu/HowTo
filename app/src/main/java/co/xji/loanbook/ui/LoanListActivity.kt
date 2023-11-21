package co.xji.loanbook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.xji.loanbook.R
import co.xji.loanbook.adapter.LoanAdapter
import co.xji.loanbook.model.LoanModel

class LoanListActivity : AppCompatActivity(), LoanAdapter.OnLoanClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loanAdapter: LoanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val loans = generateDummyLoanData() // 使用模拟数据的代码
        loanAdapter = LoanAdapter(loans, this)
        recyclerView.adapter = loanAdapter
    }

    override fun onLoanClick(loan: LoanModel) {
        // 处理贷款点击事件，跳转到贷款详情页面
        // 在这里添加Intent的代码
    }

    private fun generateDummyLoanData(): List<LoanModel> {
        val loanList = mutableListOf<LoanModel>()

        // 添加几个模拟的贷款项
        loanList.add(
            LoanModel(
                1,
                "Personal Loan 1",
                8.5,
                10000.0,
                12,
                50.0,
                "https://icons.appfigures.com/336758457452/176"
            )
        )
        loanList.add(
            LoanModel(
                2,
                "Personal Loan 2",
                9.0,
                15000.0,
                24,
                75.0,
                "https://icons.appfigures.com/337068002591/176"
            )
        )
        loanList.add(
            LoanModel(
                3,
                "Personal Loan 3",
                7.5,
                8000.0,
                18,
                40.0,
                "https://icons.appfigures.com/334202106924/176"
            )
        )

        return loanList
    }
}