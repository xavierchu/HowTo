package co.xji.loanbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.xji.loanbook.R
import co.xji.loanbook.model.HowToDoItem

// HowToDoAdapter.kt
class HowToDoAdapter(private val items: List<HowToDoItem>) :
    RecyclerView.Adapter<HowToDoAdapter.ViewHolder>() {

    companion object {
        var onItemClickListener: ((Int) -> Unit)? = null
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_how_to_do, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        // 在这里为每个 ViewHolder 设置点击监听器
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val backgroundImageView: ImageView = itemView.findViewById(R.id.backgroundImageView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(item: HowToDoItem) {
            backgroundImageView.setImageResource(item.backgroundResourceId)
            descriptionTextView.text = item.description

            // 在这里为每个 ViewHolder 设置点击监听器
            itemView.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }
    }
}


