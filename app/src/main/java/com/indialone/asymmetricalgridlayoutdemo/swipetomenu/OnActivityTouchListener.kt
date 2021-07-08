package com.indialone.asymmetricalgridlayoutdemo.swipetomenu

import android.view.MotionEvent

interface OnActivityTouchListener {

    fun getTouchCoordinates(motionEvent: MotionEvent)

}