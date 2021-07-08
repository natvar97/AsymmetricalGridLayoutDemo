package com.indialone.asymmetricalgridlayoutdemo.swipetomenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.asymmetricalgridlayoutdemo.R
import com.indialone.asymmetricalgridlayoutdemo.databinding.ActivitySwipeToDeleteUndoBinding

class SwipeToMenuActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySwipeToDeleteUndoBinding
    private lateinit var recyclerViewAdapter: SwipeToMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySwipeToDeleteUndoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = SwipeToMenuAdapter(actorsList())
        mBinding.recyclerView.adapter = recyclerViewAdapter
        setTouchListener()

    }

    private fun setTouchListener() {
        val touchListener = RecyclerTouchListener(this, mBinding.recyclerView)

        touchListener.setClickable(object : RecyclerTouchListener.OnRowClickListener {
            override fun onRowClicked(position: Int) {
                Toast.makeText(
                    this@SwipeToMenuActivity,
                    actorsList().get(position).name,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onIndependentViewClicked(independentViewID: Int, position: Int) {}
        })
            .setSwipeOptionViews(R.id.delete_task, R.id.edit_task)
            ?.setSwipeable(
                R.id.rowFG,
                R.id.rowBG,
                object : RecyclerTouchListener.OnSwipeOptionsClickListener {
                    override fun onSwipeOptionClicked(viewID: Int, position: Int) {
                        when (viewID) {
                            R.id.delete_task -> {
                                actorsList().removeAt(position)
                                recyclerViewAdapter.setTaskList(actorsList())
                            }
                            R.id.edit_task -> {
                                Toast.makeText(
                                    this@SwipeToMenuActivity,
                                    "Edit functionality not available",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                })

        mBinding.recyclerView.addOnItemTouchListener(touchListener)

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
        ActorEntity("Vijay", "He is most famous actor in Tamil Cinema", R.drawable.master_vijay),
    )

}