package com.indialone.asymmetricalgridlayoutdemo.asymmetricgrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.indialone.asymmetricalgridlayoutdemo.model.Actor
import com.indialone.asymmetricalgridlayoutdemo.databinding.GalleryItemLayoutBinding

class GalleryAdapter(
    private val actors: ArrayList<Actor>
) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    class GalleryViewHolder(itemView: GalleryItemLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val ivImage = itemView.ivImage
        private val tvTitle = itemView.tvTitle

        fun bind(actor: Actor) {
            tvTitle.text = actor.name
            Glide.with(itemView.context)
                .load(actor.image)
                .into(ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view =
            GalleryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount(): Int {
        return actors.size
    }
}