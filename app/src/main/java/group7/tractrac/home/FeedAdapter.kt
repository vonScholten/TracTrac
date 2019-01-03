package group7.tractrac.home

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.widget.CircularProgressDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import group7.tractrac.R

@GlideModule
class MyAppGlideModule : AppGlideModule()

class FeedAdapter(private val context: Context?,
                  private val feed: List<FeedData>) : BaseAdapter() {

    val storage = FirebaseStorage.getInstance()
    private lateinit var loader : LottieAnimationView

    private val inflater: LayoutInflater
            = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return feed.size
    }

    override fun getItem(i: Int): Any {
        return feed[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.custom_cardview_feed, viewGroup, false)

        val titleTextView = rowView.findViewById(R.id.feed_title) as TextView
        val imageView = rowView.findViewById(R.id.feed_cover) as ImageView
        val loader : LottieAnimationView = rowView.findViewById(R.id.imageLoader) as LottieAnimationView

        val  data : FeedData = feed.get(i)

        val requestOptions : RequestOptions = RequestOptions()
            .centerCrop()

        loader.visibility = View.VISIBLE
        Glide
            .with(rowView)
            .load(data.imageUrl)
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("TAG", "Error loading image", e);
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    loader.visibility = View.GONE
                    return false
                }
            }
                )
            .into(imageView)

        titleTextView.text = data.name

        return rowView
    }
}
