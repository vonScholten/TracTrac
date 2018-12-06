package group7.tractrac.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import group7.tractrac.R


class FeedFragment : Fragment() {

    private lateinit var title : String
    private lateinit var imageUrl : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        val feedTitle = view.findViewById(R.id.feed_article_title) as TextView
        val feedCover = view.findViewById(R.id.feed_article_cover) as ImageView

        arguments?.getString("title")?.let {
            title = it
        }

        arguments?.getString("imageUrl")?.let {
            imageUrl = it
        }

        feedTitle.text =title

        Picasso.get().load(imageUrl).into(feedCover)

        return view


    }

}
