package com.indialone.asymmetricalgridlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.indialone.asymmetricalgridlayoutdemo.databinding.ActivityStaggeredBinding

class StaggeredActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityStaggeredBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityStaggeredBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val layoutManager = StaggeredGridLayoutManager(2 , LinearLayoutManager.HORIZONTAL)

        mBinding.rvStaggered.layoutManager = layoutManager

        mBinding.rvStaggered.adapter = GalleryAdapter(actorsList())
    }

    private fun actorsList(): ArrayList<Actor> {
        return arrayListOf(
            Actor("image1", R.drawable.image1),
            Actor("image2", R.drawable.image2),
            Actor("image3", R.drawable.image3),
            Actor("image4", R.drawable.image4),
            Actor("image5", R.drawable.image5),
            Actor("image6", R.drawable.image6),
            Actor("image7", R.drawable.image7),
            Actor("image8", R.drawable.image8),
            Actor("image9", R.drawable.image9),
            Actor("image10", R.drawable.image10),
            Actor("image11", R.drawable.image11),
            Actor("image1", R.drawable.image1),
            Actor("image2", R.drawable.image2),
            Actor("image3", R.drawable.image3),
            Actor("image4", R.drawable.image4),
            Actor("image5", R.drawable.image5),
            Actor("image6", R.drawable.image6),
            Actor("image7", R.drawable.image7),
            Actor("image8", R.drawable.image8),
            Actor("image9", R.drawable.image9),
            Actor("image10", R.drawable.image10),
            Actor("image11", R.drawable.image11),
            Actor("image11", R.drawable.image11),
            Actor("image1", R.drawable.image1),
            Actor("image2", R.drawable.image2),
            Actor("image3", R.drawable.image3),
            Actor("image4", R.drawable.image4),
            Actor("image5", R.drawable.image5),
            Actor("image6", R.drawable.image6),
            Actor("image7", R.drawable.image7),
            Actor("image8", R.drawable.image8),
            Actor("image9", R.drawable.image9),
            Actor("image10", R.drawable.image10),
            Actor("image11", R.drawable.image11),

        )
    }
}