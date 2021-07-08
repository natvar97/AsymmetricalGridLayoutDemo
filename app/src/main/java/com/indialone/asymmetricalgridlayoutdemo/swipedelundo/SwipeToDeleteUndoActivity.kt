package com.indialone.asymmetricalgridlayoutdemo.swipedelundo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.indialone.asymmetricalgridlayoutdemo.R
import com.indialone.asymmetricalgridlayoutdemo.databinding.ActivitySwipeToDeleteUndoBinding

class SwipeToDeleteUndoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySwipeToDeleteUndoBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SwipeToDeleteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySwipeToDeleteUndoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        recyclerView = mBinding.recyclerView

        setUpRecyclerView()
        swipeToDeleteAndUndoImplement()
    }

    private fun swipeToDeleteAndUndoImplement() {
        val callback = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.absoluteAdapterPosition
                val item = adapter.getData().get(position)

                adapter.removeItem(position)

                val snackBar = Snackbar.make(
                    mBinding.layout,
                    "Item was removed from the list.",
                    Snackbar.LENGTH_LONG
                )
                snackBar.setAction("UNDO") {
                    adapter.restoreItem(item, position)
                    recyclerView.scrollToPosition(position)
                }
                snackBar.setActionTextColor(Color.YELLOW)
                snackBar.show()

            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SwipeToDeleteAdapter(getList())
        recyclerView.adapter = adapter
    }

    private fun getList(): ArrayList<String> {
        return arrayListOf(
            "Item1",
            "Item2",
            "Item3",
            "Item4",
            "Item5",
            "Item6",
            "Item7",
            "Item8",
            "Item9",
            "Item10",
            "Item11",
            "Item12",
            "Item13",
            "Item14",
            "Item15",
        )
    }
}