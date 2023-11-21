package co.xji.loanbook.adapter.guide

// GuideAdapter.kt
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.xji.loanbook.R
import co.xji.loanbook.model.guide.GuideModel
import co.xji.loanbook.ui.guide.GuideDetailActivity


// GuideAdapter.kt
class GuideAdapter(private val context: Context, private val guides: List<GuideModel>) :
    RecyclerView.Adapter<GuideAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_guide, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val guide = guides[position]
        holder.bind(guide)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, GuideDetailActivity::class.java)
            intent.putExtra(GuideDetailActivity.EXTRA_GUIDE_TITLE, guide.title)
            intent.putExtra(GuideDetailActivity.EXTRA_GUIDE_DESCRIPTION, guide.description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return guides.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivGuideIcon: ImageView = itemView.findViewById(R.id.ivGuideIcon)
        private val tvGuideTitle: TextView = itemView.findViewById(R.id.tvGuideTitle)

        fun bind(guide: GuideModel) {
            // 设置图标和标题
            ivGuideIcon.setImageResource(guide.iconResId)
            tvGuideTitle.text = guide.title
        }
    }
}
