package com.y4n9b0.ak

import android.graphics.Rect
import android.view.MotionEvent
import android.view.TouchDelegate
import android.view.View
import android.view.ViewConfiguration

/**
 * 继承自 {@link android.view.TouchDelegate}，重写方法 {@link android.view.TouchDelegate#onTouchEvent(MotionEvent)}，
 * 解决 Android 9.0 以下 container 无法响应点击事件的 bug（参考 https://www.jianshu.com/p/ce14c7d96b0c）
 */
internal class TouchDelegateCompat(private val bounds: Rect, private val delegateView: View) :
    TouchDelegate(bounds, delegateView) {

    /**
     * mBounds inflated to include some slop. This rect is to track whether the motion events
     * should be considered to be within the delegate view.
     */
    private val slopBounds: Rect

    /**
     * True if the delegate had been targeted on a down event (intersected mBounds).
     */
    private var delegateTargeted = false

    private val slop: Int = ViewConfiguration.get(delegateView.context).scaledTouchSlop

    /**
     * Forward touch events to the delegate view if the event is within the bounds
     * specified in the constructor.
     *
     * @param event The touch event to forward
     * @return True if the event was consumed by the delegate, false otherwise.
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        var sendToDelegate = false
        var hit = true
        var handled = false
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                delegateTargeted = bounds.contains(x, y)
                sendToDelegate = delegateTargeted
            }
            MotionEvent.ACTION_POINTER_DOWN, MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_UP, MotionEvent.ACTION_MOVE -> {
                sendToDelegate = delegateTargeted
                if (sendToDelegate) {
                    val slopBounds = slopBounds
                    if (!slopBounds.contains(x, y)) {
                        hit = false
                    }
                }
            }
            MotionEvent.ACTION_CANCEL -> {
                sendToDelegate = delegateTargeted
                delegateTargeted = false
            }
        }
        if (sendToDelegate) {
            if (hit) {
                // Offset event coordinates to be inside the target view
                event.setLocation(delegateView.width / 2f, delegateView.height / 2f)
            } else {
                // Offset event coordinates to be outside the target view (in case it does
                // something like tracking pressed state)
                val slop = slop
                event.setLocation(-(slop * 2f), -(slop * 2f))
            }
            handled = delegateView.dispatchTouchEvent(event)
        }
        return handled
    }

    init {
        slopBounds = Rect(bounds).apply { inset(-slop, -slop) }
    }
}
