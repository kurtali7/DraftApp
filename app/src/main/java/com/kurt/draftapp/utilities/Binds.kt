package com.kurt.draftapp.utilities

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.kurt.draftapp.R
import com.kurt.draftapp.data.model.Track
import com.squareup.picasso.Picasso
import java.text.ParseException
import java.text.SimpleDateFormat

object Binds {

    @BindingAdapter("artwork")
    @JvmStatic
    fun loadImageTrack(imageView: ImageView?, imageURL: String?) {
        Picasso.get()
            .load(imageURL)
            .placeholder(R.drawable.image_list_placeholder)
            .fit()
            .into(imageView)
    }

    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(iv: ImageView, url: String?) {
        if (url != null) {
            Glide.with(iv.context)
                .asBitmap()
                .load(url)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?,
                    ) {
                        iv.setImageBitmap(resource)
                    }
                })
        }
    }


    @BindingAdapter("formatDate")
    @JvmStatic
    fun TextView.setDate(order_date: String?) {
        if (order_date != null) {
            var outputDate: String? = null
            try {
                val curFormater = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                val postFormater = SimpleDateFormat("MMM dd, yyyy")

                val dateObj = curFormater.parse(order_date)
                outputDate = postFormater.format(dateObj)
                this.setText(outputDate)

            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
    }

    fun TextView.handleUrlClicks(onClicked: ((String) -> Unit)? = null) {
        text = SpannableStringBuilder.valueOf(text).apply {
            getSpans(0, length, URLSpan::class.java).forEach {
                setSpan(
                    object : ClickableSpan() {
                        override fun onClick(widget: View) {
                            onClicked?.invoke(it.url)
                        }
                    },
                    getSpanStart(it),
                    getSpanEnd(it),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                removeSpan(it)
            }
        }
        movementMethod = LinkMovementMethod.getInstance()
    }

}