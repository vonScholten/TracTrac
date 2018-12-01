package group7.tractrac.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import group7.tractrac.R
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var listView : ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listView = view.findViewById(R.id.news_list_view) as ListView

        FirebaseApp.initializeApp(context)
        val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("feed")

        val mData : List<ModelData> = ArrayList<ModelData>()

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, databaseError.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                (mData as ArrayList<ModelData>).clear()

                for (postSnapshot : DataSnapshot in dataSnapshot.children){
                    val data = postSnapshot.getValue(ModelData::class.java)
                    mData.add(data!!)
                }
                val adapter = ModelAdapter(context, mData)
                listView.adapter = adapter
            }

        })

        //val data = getData()

        return view

    }


    fun getData(): ArrayList<String> {

        val news_list : ArrayList<String> = arrayListOf()
        news_list.add("Big win for Denmark" + "," + R.drawable.volvo_ocean)
        news_list.add("Team Sky going for a win" + "," + R.drawable.sky)
        news_list.add("Big win for Denmark" + "," + R.drawable.volvo_ocean)
        news_list.add("Team Sky going for a win" + "," + R.drawable.sky)
        news_list.add("Big win for Denmark" + "," + R.drawable.volvo_ocean)
        news_list.add("Team Sky going for a win" + "," + R.drawable.sky)
        news_list.add("Big win for Denmark" + "," + R.drawable.volvo_ocean)
        news_list.add("Team Sky going for a win" + "," + R.drawable.sky)


        return news_list
    }


}
