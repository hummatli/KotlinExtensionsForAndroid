@file:JvmName("Extensions")
package com.hummatli.kotlin.extensions

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by settar on 6/23/17.
 */


fun TextView.decorateAsLink() {
    this.movementMethod = LinkMovementMethod.getInstance()
}


fun TextView.setFont(fontName: String?) =
        if (fontName != null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, fontName)
            } catch (r: RuntimeException) {
                Log.e("test", "Error " + r.message)
            }
        } else {
        }

fun Array<TextView>.setFont(font: String?) {
    for (v in this) {
        v.setFont(font)
    }
}

fun ViewGroup.setFontOnChildTextView(fontName: String) {
    // Find the TextView that is inside of the SignInButton and set its text
    for (i in 0..childCount - 1) {
        val v = getChildAt(i)
        if (v is TextView) {
            v.setFont(fontName)
        }
    }
}

fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE
fun View.isGone(): Boolean = visibility == View.GONE
fun View.isInVisible(): Boolean = visibility == View.INVISIBLE


fun ImageView.setColorFilterCompat(color: Int, mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN) {
    setColorFilter(ContextCompat.getColor(context, color), mode)
}

fun Context.getDrawableWithColorFilter(id: Int, color: Int, mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN): Drawable {
    val drawable = ContextCompat.getDrawable(this, id)
    drawable.setColorFilter(ContextCompat.getColor(this, color), mode)
    return drawable
}

fun View.startAnimationFillAfter(id: Int, fillAfter: Boolean = true) {
    val animRotate = AnimationUtils.loadAnimation(context, id)
    animRotate.fillAfter = fillAfter //For the textview to remain at the same place after the rotation
    animation = animRotate
    startAnimation(animRotate)
}


fun View.setBackgroundExt(drawable: Drawable) {
    val sdk = android.os.Build.VERSION.SDK_INT
    if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        setBackgroundDrawable(drawable)
    } else {
        background = drawable
    }
}

