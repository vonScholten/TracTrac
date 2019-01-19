package group7.tractrac.home


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import group7.tractrac.R
import kotlinx.android.synthetic.main.fragment_feed.view.*


class FeedFragment : Fragment() {

    private lateinit var title : String
    private lateinit var imageUrl : String
    private lateinit var date : String
    private lateinit var text : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)

        val feedTitle = view.findViewById(R.id.feed_detail_title) as TextView
        val feedCover = view.findViewById(R.id.feed_detail_image) as ImageView
        val feedText = view.findViewById(R.id.feed_detail_subtitle) as TextView
        val feedDate = view.findViewById(R.id.feed_detail_date) as TextView

        val scrollView = view.findViewById(R.id.feed_detail_ScrollView) as ScrollView

        arguments?.getString("title")?.let {
            title = it
        }
        arguments?.getString("imageUrl")?.let {
            imageUrl = it
        }
        arguments?.getString("date")?.let {
            date = it
        }
        arguments?.getString("text")?.let {
            text = it
        }

        val requestOptions : RequestOptions = RequestOptions()
            .centerCrop()

        Glide
            .with(view)
            .load(imageUrl)
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("TAG", "Error loading image", e)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    feedTitle.text =title
                    feedText.text =text
                    feedDate.text =date
                    scrollView.smoothScrollTo(0, 200)
                    return false
                }
            }
            )
            .into(feedCover)

        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        view.startAnimation(animation)

        return view


    }

}
