package com.indialone.asymmetricalgridlayoutdemo.swipetomenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.asymmetricalgridlayoutdemo.databinding.ActorItemSwipeMenuBinding
import com.indialone.asymmetricalgridlayoutdemo.databinding.MenuLayoutBinding

class SwipeToMenuAdapter(
    private var actors: ArrayList<ActorEntity>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val SHOW_MENU = 1
    private val HIDE_MENU = 2

    class MenuViewHolder(itemView: MenuLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
        val ivDelete = itemView.ivDelete
        val ivEdit = itemView.ivEdit
    }

    class SwipeToMenuViewHolder(itemView: ActorItemSwipeMenuBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val tvName = itemView.tvName
        private val tvAbout = itemView.tvAbout
        private val iv = itemView.iv

        fun bind(actor: ActorEntity) {
            tvName.text = actor.name
            tvAbout.text = actor.about
            Glide.with(itemView.context)
                .load(actor.image)
                .into(iv)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (actors[position].showMenu) SHOW_MENU
        else HIDE_MENU
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == SHOW_MENU) {
            val view = MenuLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return MenuViewHolder(view)
        } else {
            val view = ActorItemSwipeMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return SwipeToMenuViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val actor = actors[position]
        if (holder is MenuViewHolder) {
            holder.ivDelete.setOnClickListener {
                actors.removeAt(position)
                notifyItemRemoved(position)
            }
            holder.ivEdit.setOnClickListener {
                Toast.makeText(
                    holder.itemView.context,
                    "Edit functionality is not available",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        if (holder is SwipeToMenuViewHolder) {
            holder.bind(actor)
            holder.itemView.setOnLongClickListener {
                showMenu(position)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    fun setTaskList(actorsList: List<ActorEntity>) {
        actors = actorsList as ArrayList<ActorEntity>
        notifyDataSetChanged()
    }

    fun showMenu(position: Int) {
        for (item in actors) {
            item.showMenu = false
        }
        actors.get(position).showMenu = true
        notifyDataSetChanged()
    }

    fun isMenuShow(): Boolean {
        for (item in actors) {
            if (item.showMenu) return true
        }
        return false
    }

    fun closeMenu() {
        for (item in actors) {
            item.showMenu = false
        }
        notifyDataSetChanged()
    }

}