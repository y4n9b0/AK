@file:OptIn(ExperimentalCoroutinesApi::class)
@file:Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package com.y4n9b0.ak

import android.graphics.Rect
import android.os.Build
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntDef
import androidx.annotation.Px
import androidx.core.view.doOnLayout
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlin.internal.InlineOnly

@IntDef(value = [View.VISIBLE, View.INVISIBLE, View.GONE])
@Retention(AnnotationRetention.SOURCE)
internal annotation class Visibility

@InlineOnly
inline fun View.visibleIf(bool: Boolean, @Visibility `else`: Int = View.GONE): View = apply {
    visibility = if (bool) View.VISIBLE else `else`
}

/**
 * 点击去重
 */
inline fun View.clicks(
    scope: CoroutineScope,
    duration: Long = 500L,
    crossinline onIgnore: (view: View, interval: Long) -> Unit = { _, _ -> },
    crossinline onClick: (View) -> Unit
): View = apply {
    callbackFlow {
        this@clicks.setOnClickListener { trySend(System.currentTimeMillis()) }
        awaitClose { this@clicks.setOnClickListener(null) }
    }.distinctUntilChanged { old, new ->
        (new - old < duration).also { if (it) onIgnore(this@clicks, new - old) }
    }.onEach {
        onClick(this@clicks)
    }.launchIn(scope)
}

@Deprecated("Too dangerous for newbie!", level = DeprecationLevel.HIDDEN)
val View.ctxLifecycleScope: LifecycleCoroutineScope
    get() = (context as? LifecycleOwner)?.lifecycleScope
        ?: throw TypeCastException("Can not cast context@$this to LifecycleOwner!")

/**
 * 扩展点击区域
 *
 * @param ancestor      接收扩展事件的祖先，可以是其任意层级的parent.
 *                      扩展的有效范围不会超过ancestor.
 *                      同一个ancestor无法接收多个view的扩展，只有最后设置的扩展会生效.
 * @param expandLeft    左边扩展大小，单位px
 * @param expandTop     顶部扩展大小，单位px
 * @param expandRight   右边扩展大小，单位px
 * @param expandBottom  底部扩展大小，单位px
 */
fun View.expandTouchArea(
    ancestor: ViewGroup,
    @Px expandLeft: Int,
    @Px expandTop: Int = expandLeft,
    @Px expandRight: Int = expandLeft,
    @Px expandBottom: Int = expandLeft
): View = apply {
    doOnLayout {
        val boss = IntArray(2)
        val target = IntArray(2)
        getLocationInWindow(boss)
        ancestor.getLocationInWindow(target)
        val l = boss[0] - target[0]
        val t = boss[1] - target[1]
        val r = l + width
        val b = t + height
        val bounds = Rect().apply {
            top = t - expandTop
            bottom = b + expandBottom
            left = l - expandLeft
            right = r + expandRight
        }
        ancestor.touchDelegate =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) TouchDelegate(bounds, it)
            else TouchDelegateCompat(bounds, it)
    }
}
