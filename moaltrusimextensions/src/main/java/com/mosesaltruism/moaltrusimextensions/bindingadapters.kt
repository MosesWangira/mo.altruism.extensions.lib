package com.mosesaltruism.moaltrusimextensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Binding adapter used to display images from URL or Drawable using Glide
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).error(R.drawable.no_image).into(imageView)
}

@BindingAdapter("imageUrlTwo")
fun setImageUrlTwo(imageView: ImageView, drawable: Int) {
    Glide.with(imageView.context).load(drawable).error(R.drawable.no_image).into(imageView)
}