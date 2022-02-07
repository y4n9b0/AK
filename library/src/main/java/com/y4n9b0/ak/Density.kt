package com.y4n9b0.ak

import android.content.res.Resources
import kotlin.math.roundToInt

private val system get() = Resources.getSystem()
private val metrics get() = system.displayMetrics

val Number.dp2px
    get() = toFloat().times(metrics.density).roundToInt()

val Number.sp2px
    get() = toFloat().times(metrics.scaledDensity).roundToInt()

val Number.px2dp
    get() = toFloat().div(metrics.density)

val Number.px2sp
    get() = toFloat().div(metrics.scaledDensity)

val SCREEN_WIDTH: Int
    get() = metrics.widthPixels

val SCREEN_HEIGHT: Int
    get() = metrics.heightPixels

val STATUS_BAR_HEIGHT: Int
    get() {
        val resId = system.getIdentifier("status_bar_height", "dimen", "android")
        return if (resId != 0) system.getDimensionPixelSize(resId) else 24.dp2px
    }

/**
 * 10.dp2x          使用更加方便，但是污染整个 Number
 * Dp(10).toPx()    使用 value class 包装避免了对 Number 的污染，但是使用更加繁琐
 *
 * 综合比较，还是推荐使用前者，毕竟我们扩展的初衷就是为了使用更加方便。
 * 以下几个 value class Sp 和 Px 类似。
 */
@Deprecated(
    message = "Inconvenient to use",
    replaceWith = ReplaceWith("Number.dp2px"),
    level = DeprecationLevel.HIDDEN
)
@JvmInline
value class Dp(private val n: Number) {
    fun toPx(): Int {
        return n.toFloat().times(metrics.density).roundToInt()
    }
}

@Deprecated(
    message = "Inconvenient to use",
    replaceWith = ReplaceWith("Number.sp2px"),
    level = DeprecationLevel.HIDDEN
)
@JvmInline
value class Sp(private val n: Number) {
    fun toPx(): Int {
        val metrics = Resources.getSystem().displayMetrics
        return n.toFloat().times(metrics.scaledDensity).roundToInt()
    }
}

@Deprecated(
    message = "Inconvenient to use",
    replaceWith = ReplaceWith("Number.px2dp or Number.ps2sp"),
    level = DeprecationLevel.HIDDEN
)
@JvmInline
value class Px(private val n: Number) {
    fun toDp(): Float {
        val metrics = Resources.getSystem().displayMetrics
        return n.toFloat().div(metrics.density)
    }

    fun toSp(): Float {
        val metrics = Resources.getSystem().displayMetrics
        return n.toFloat().div(metrics.scaledDensity)
    }
}
