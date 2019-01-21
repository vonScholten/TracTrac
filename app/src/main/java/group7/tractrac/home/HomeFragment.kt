package group7.tractrac.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import group7.tractrac.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var listView: ListView
    private lateinit var adapter: FeedAdapter
    private lateinit var loader: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        listView = view.findViewById(R.id.news_list_view) as ListView
        loader = view.findViewById(R.id.imageLoader) as LottieAnimationView

        loader.speed = 2.0F

        listView.visibility = View.GONE

        val job = GlobalScope.launch {
            //delay(1500L)
            fetch()
        }
        job.children

        listView.visibility = View.VISIBLE

        return view

    }

    override fun onClick(v: View?) {

    }

    private fun fetch() {
        FirebaseApp.initializeApp(context)
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("feed")

        val feed: List<FeedData> = ArrayList<FeedData>()

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                (feed as ArrayList<FeedData>).clear()

                for (postSnapshot: DataSnapshot in dataSnapshot.children) {
                    val temp = postSnapshot.getValue(FeedData::class.java)
                    feed.add(temp!!)
                }
                adapter = FeedAdapter(context, feed)
                listView.adapter = adapter

                listView.onItemClickListener = object : AdapterView.OnItemClickListener {
                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                        // value of item that is clicked
                        val data = listView.getItemAtPosition(position) as FeedData

                        val fragment = FeedFragment().apply {
                            arguments = Bundle().apply {
                                this.putString("title", data.name)
                                this.putString("imageUrl", data.imageUrl)
                                this.putString("date", data.date)
                                this.putString("text", data.text)
                            }
                        }

                        fragmentManager!!
                            .beginTransaction()
                            .addToBackStack(tag)
                            .replace(R.id.fragmentFrame, fragment, tag)
                            .commit()

                    }

                }

                loader.visibility = View.GONE   //hide loader when done loading
            }
        })
    }
}
