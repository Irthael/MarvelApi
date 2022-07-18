package com.dani.apimarvel.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.dani.domain.Image
import com.squareup.picasso.Picasso

/**
 * This class gather the binding adapters used within the application
 *
 * Every function for this class will be called exclusively from the autogenerated classes from
 * the DataBinding process
 */
@Suppress("TooManyFunctions")
object BindingAdapters {
    private const val BLINKING_DURATION = 1500L


    @BindingAdapter("visible")
    @JvmStatic
    fun setVisibile(view: View, value: Boolean?) {
        view.visibility = if (value == true) View.VISIBLE else View.GONE
    }

    @BindingAdapter(
        value = ["imageUrl"],
        requireAll = false
    )
    @JvmStatic
    fun setImageUrlWithDefault(
        imageView: ImageView,
        image: Image?
    ) {
        if (image==null) imageView.setImageDrawable(null)
        else {
            val url = "${image.path}.${image.extension}".replace("http", "https")
            Picasso.get().load(url).into(imageView)
            /*
            GlideApp.with(imageView)
                .load(url)
                .onlyRetrieveFromCache(true)
                .into(imageView)
            */
        }
    }
}