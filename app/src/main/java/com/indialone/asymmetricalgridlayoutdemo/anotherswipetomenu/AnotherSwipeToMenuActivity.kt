package com.indialone.asymmetricalgridlayoutdemo.anotherswipetomenu

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.indialone.asymmetricalgridlayoutdemo.R
import com.indialone.asymmetricalgridlayoutdemo.databinding.ActivityAnotherSwipeToMenuBinding
import com.indialone.asymmetricalgridlayoutdemo.swipetomenu.ActorEntity
import com.indialone.asymmetricalgridlayoutdemo.swipetomenu.SwipeToMenuAdapter


class AnotherSwipeToMenuActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAnotherSwipeToMenuBinding
    private lateinit var adapter: SwipeToMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAnotherSwipeToMenuBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        adapter = SwipeToMenuAdapter(actorsList())
        mBinding.rv.layoutManager = LinearLayoutManager(this)
        mBinding.rv.adapter = adapter
        getTouchListener()

    }

    private fun getTouchListener() {
        val touchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            private val background = ColorDrawable(resources.getColor(R.color.blue))

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.showMenu(viewHolder.adapterPosition)
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val itemView = viewHolder.itemView

                if (dX > 0) {
                    background.setBounds(
                        itemView.left,
                        itemView.top,
                        itemView.left + dX.toInt(),
                        itemView.bottom
                    )
                } else if (dX < 0) {
                    background.setBounds(
                        itemView.right + dX.toInt(),
                        itemView.top,
                        itemView.right,
                        itemView.bottom
                    )
                } else {
                    background.setBounds(0, 0, 0, 0)
                }
                background.draw(c)

            }
        }

        val itemTouchHelper = ItemTouchHelper(touchHelperCallback)
        itemTouchHelper.attachToRecyclerView(mBinding.rv)

    }

    private fun actorsList() = arrayListOf<ActorEntity>(
        ActorEntity(
            "Robert Downey Jr",
            "He is famous for Sherlock Holmes and Iron Man",
            R.drawable.image_rdj
        ),
        ActorEntity(
            "Akshay Kumar",
            "He is known for his role and acting and comedy also eg.Hera Pheri",
            R.drawable.image_akshay
        ),
        ActorEntity(
            "Rashmika Mandana",
            "She is National Crush of India and She is known for her Beauty and Cuteness",
            R.drawable.image_rashmika
        ),
        ActorEntity(
            "Allu Arjun",
            "He is most favourite actor from South India known for Arya series , Son of SatyaMurti , Surya the soldier",
            R.drawable.image_allu_arjun
        ),
        ActorEntity(
            "Christian Bale",
            "He is known for his role because he is deep in his role . known for Batman",
            R.drawable.image_christian_bale
        ),
        ActorEntity(
            "Johny Depp",
            "He is the world famous actor known for his role Jack Sparrow in Pirates of the Caribbean movie series",
            R.drawable.image_johny_depp
        ),
        ActorEntity(
            "Kajal Agarwal",
            "She is very beautiful Actress and cute as always",
            R.drawable.image_kajal
        ),
        ActorEntity(
            "Leonardo the Capriko",
            "He is the most decent actor in Hollywood cinema. Known for Inception , Once upon a time in Hollywood",
            R.drawable.image_leonardo
        ),
        ActorEntity(
            "Vijay Sethupati",
            "He is the most decent actor in South Indian Cinema and known for his decent acting",
            R.drawable.master_vijay_sethupati
        ),
        ActorEntity(
            "Vijay",
            "He is most famous actor in Tamil Cinema",
            R.drawable.master_vijay
        ),
    )

}