package group7.tractrac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static io.fabric.sdk.android.Fabric.TAG;


public class PastEventsFragment extends Fragment implements AdapterView.OnItemClickListener {

    TextView titleview;
    TextView categoryview;
    TextView dateview;
    TextView racesview;
    ImageView eventimageview;
    TextView location_name;
    public static int eventid = 0;
    private DatabaseReference databaseReference;
    private List<EventsData> eventsDataList;
    static String title;
    static String date;
    static String location;
    static long racesnr;

    ListView events;

    public PastEventsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_past_events, container, false);
        events = inflaterview.findViewById(R.id.eventlist);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("past");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventsDataList.clear();
                for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                    EventsData eventsData = postSnapShot.getValue(EventsData.class);
                    eventsDataList.add(eventsData);
                }
                CustomAdapter eventadapter = new CustomAdapter(eventsDataList);
                events.setAdapter(eventadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        events.setOnItemClickListener(this);


        return inflaterview;
    }

    class CustomAdapter extends BaseAdapter{
        private List<EventsData> eventsDataList;

        public CustomAdapter(List<EventsData> eventsDataList) {
            this.eventsDataList = eventsDataList;
        }

        @Override
        public int getCount() {
            return eventsDataList.size();
        }

        @Override
        public Object getItem(int i) {
            return eventsDataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return (long) i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.custom_layout_events, null);

            eventimageview = view.findViewById(R.id.eventimage);
            titleview =  view.findViewById(R.id.title);
            categoryview = view.findViewById(R.id.category);
            dateview = view.findViewById(R.id.date);
            racesview = view.findViewById(R.id.races);
            location_name = view.findViewById(R.id.location_text);

            EventsData eventsData = eventsDataList.get(i);
            Picasso.get().load(eventsData.getImageUrl()).into(eventimageview);

            titleview.setText(eventsData.getTitle());
            categoryview.setText(eventsData.getCategory());
            dateview.setText(eventsData.getDate());
            racesview.setText(eventsData.getRaces());
            location_name.setText(eventsData.getLocation());

            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
            view.startAnimation(animation);


            return view;
        }
    }


    public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
        // arg2 = the id of the item in our view (List/Grid) that we clicked
        // arg3 = the id of the item that we have clicked
        // if we didn't assign any id for the Object (Book) the arg3 value is 0
        // That means if we comment, aBookDetail.setBookIsbn(i); arg3 value become 0

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (arg2 == 0){
                    eventid = 0;
                    title = dataSnapshot.child("01").child("title").getValue().toString();
                    date = dataSnapshot.child("01").child("date").getValue().toString();
                    location = dataSnapshot.child("01").child("location").getValue().toString();
                    racesnr = (long) dataSnapshot.child("01").child("racenr").getValue();
                }
                else if (arg2 == 1){
                    eventid = 1;
                    title = dataSnapshot.child("02").child("title").getValue().toString();
                    date = dataSnapshot.child("02").child("date").getValue().toString();
                    location = dataSnapshot.child("02").child("location").getValue().toString();
                    racesnr = (long) dataSnapshot.child("02").child("racenr").getValue();
                }
                else if (arg2 == 2){
                    eventid = 2;
                    title = dataSnapshot.child("03").child("title").getValue().toString();
                    date = dataSnapshot.child("03").child("date").getValue().toString();
                    location = dataSnapshot.child("03").child("location").getValue().toString();
                    racesnr = (long) dataSnapshot.child("03").child("racenr").getValue();
                    //racesnr = (long) dataSnapshot.child("03").child("racenr").getValue();
                    Log.d(TAG, "Right now racesnr is set to " + racesnr);

                }
                Fragment fragment = new PastEventInfoFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentFrame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}