package com.y4n9b0.ak

import android.os.Build
import android.text.Layout
import android.text.StaticLayout
import android.text.TextDirectionHeuristics
import android.widget.TextView
import androidx.annotation.Px
import androidx.annotation.RequiresApi

fun TextView.getLineCountBeforeDrawing(@Px width: Int): Int {
    val textWidth = width - compoundPaddingLeft - compoundPaddingRight
    val staticLayout = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        getStaticLayout23(this, textWidth)
    } else {
        getStaticLayout(this, textWidth)
    }
    return staticLayout.lineCount.coerceAtMost(maxLines)
}

@RequiresApi(api = Build.VERSION_CODES.M)
private fun getStaticLayout23(tv: TextView, width: Int): StaticLayout {
    return StaticLayout.Builder.obtain(tv.text, 0, tv.text.length, tv.paint, width).apply {
        setAlignment(Layout.Alignment.ALIGN_NORMAL)
        setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR)
        setLineSpacing(tv.lineSpacingExtra, tv.lineSpacingMultiplier)
        setIncludePad(tv.includeFontPadding)
        setBreakStrategy(tv.breakStrategy)
        setHyphenationFrequency(tv.hyphenationFrequency)
        setMaxLines(if (tv.maxLines == -1) Int.MAX_VALUE else tv.maxLines)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setJustificationMode(tv.justificationMode)
        }
        if (tv.ellipsize != null && tv.keyListener == null) {
            setEllipsize(tv.ellipsize).setEllipsizedWidth(width)
        }
    }.build()
}

@Suppress("DEPRECATION")
private fun getStaticLayout(tv: TextView, width: Int): StaticLayout {
    return StaticLayout(
        tv.text,
        0,
        tv.text.length,
        tv.paint,
        width,
        Layout.Alignment.ALIGN_NORMAL,
        tv.lineSpacingMultiplier,
        tv.lineSpacingExtra,
        tv.includeFontPadding,
        tv.ellipsize,
        width
    )
}
