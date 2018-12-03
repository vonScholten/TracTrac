package group7.tractrac.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import group7.tractrac.R
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var listView : ListView
    private lateinit var adapter: FeedAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listView = view.findViewById(R.id.news_list_view) as ListView

        FirebaseApp.initializeApp(context)
        val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("feed")

        val feed : List<FeedData> = ArrayList<FeedData>()

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                (feed as ArrayList<FeedData>).clear()

                for (postSnapshot : DataSnapshot in dataSnapshot.children){
                    val data = postSnapshot.getValue(FeedData::class.java)
                    feed.add(data!!)
                }
                adapter = FeedAdapter(context, feed)
                listView.adapter = adapter

                listView.onItemClickListener = object : AdapterView.OnItemClickListener {
                    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                        // value of item that is clicked
                        val itemValue = listView.getItemAtPosition(position) as FeedData

                        // Toast the values
                        Toast.makeText(context, itemValue.imageUrl, Toast.LENGTH_LONG)
                            .show()

                        val fragment = FeedFragment()
                        val transaction = fragmentManager!!.beginTransaction()

                        transaction.replace(R.id.fragmentFrame, fragment)
                        transaction.addToBackStack(null)
                        transaction.commit()

                    }

                }
            }
        })

        return view

    }
}
