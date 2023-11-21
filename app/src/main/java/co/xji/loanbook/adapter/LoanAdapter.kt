package co.xji.loanbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.xji.loanbook.model.LoanModel
import co.xji.loanbook.R
import com.bumptech.glide.Glide

class LoanAdapter(private val loans: List<LoanModel>, private val listener: OnLoanClickListener) :
    RecyclerView.Adapter<LoanAdapter.ViewHolder>() {

    interface OnLoanClickListener {
        fun onLoanClick(loan: LoanModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_loan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val loan = loans[position]
        holder.bind(loan)
        holder.itemView.setOnClickListener { listener.onLoanClick(loan) }
    }

    override fun getItemCount(): Int {
        return loans.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivLoanImage: ImageView = itemView.findViewById(R.id.ivLoanImage)
        private val tvLoanName: TextView = itemView.findViewById(R.id.tvLoanName)
        private val tvInterestRate: TextView = itemView.findViewById(R.id.tvInterestRate)
        private val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        private val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)
        private val tvFees: TextView = itemView.findViewById(R.id.tvFees)

        fun bind(loan: LoanModel) {
            // 使用加载图像的库（例如Glide、Picasso等）来加载图像
            // 这里使用Glide示例，确保添加Glide库的依赖

            Glide.with(itemView.context)
                .load(loan.imageUrl)
                .placeholder(R.drawable.placeholder_image) // 占位图
                .error(R.drawable.error_image) // 加载失败时显示的图像
                .into(ivLoanImage)

            tvLoanName.text = loan.name
            tvInterestRate.text = "Interest Rate: ${loan.interestRate}%"
            tvAmount.text = "Amount: ${loan.amount}"
            tvDuration.text = "Duration: ${loan.duration} months"
            tvFees.text = "Fees: ${loan.fees}"
        }
    }

}