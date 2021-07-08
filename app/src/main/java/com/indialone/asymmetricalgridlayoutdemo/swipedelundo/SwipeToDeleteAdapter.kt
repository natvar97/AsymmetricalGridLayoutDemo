package com.indialone.asymmetricalgridlayoutdemo.swipedelundo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indialone.asymmetricalgridlayoutdemo.databinding.DeleteUndoItemLayoutBinding

class SwipeToDeleteAdapter(
    private val list: ArrayList<String>
) : RecyclerView.Adapter<SwipeToDeleteAdapter.SwipeToDeleteViewHolder>() {
    class SwipeToDeleteViewHolder(itemView: DeleteUndoItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val tvTitle = itemView.txtTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeToDeleteViewHolder {
        val view =
            DeleteUndoItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SwipeToDeleteViewHolder(view)
    }

    override fun onBindViewHolder(holder: SwipeToDeleteViewHolder, position: Int) {
        holder.tvTitle.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: String, position: Int) {
        list.add(position, item)
        notifyItemInserted(position)
    }

    fun getData() : ArrayList<String> {
        return list
    }

}