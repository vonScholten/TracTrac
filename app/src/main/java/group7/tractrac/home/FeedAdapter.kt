package group7.tractrac.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import group7.tractrac.R

class FeedAdapter(private val context: Context?,
                  private val feed: List<FeedData>) : BaseAdapter() {

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

        //Get title element
        val titleTextView = rowView.findViewById(R.id.feed_title) as TextView
        val imageView = rowView.findViewById(R.id.feed_cover) as ImageView

        val  data : FeedData = feed.get(i)

        titleTextView.text = data.name
        Picasso.get().load(data.imageUrl).into(imageView)

        return rowView
    }
}
