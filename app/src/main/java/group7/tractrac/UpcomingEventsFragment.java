package group7.tractrac;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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


public class UpcomingEventsFragment extends Fragment implements AdapterView.OnItemClickListener {

    TextView titleview;
    TextView categoryview;
    TextView dateview;
    TextView racesview;
    TextView location_info;
    ImageView eventimageview;
    public static int eventid = 0;
    private DatabaseReference databaseReference;
    private List<EventsData> eventsDataList;
    //private ProgressBar spinner;
    ListView events;
    static String title;
    static  ImageView image;

    public UpcomingEventsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_upcoming_events, container, false);
        events = inflaterview.findViewById(R.id.eventlist);
        //spinner = inflaterview.findViewById(R.id.progressBar1);
        //spinner.setVisibility(View.GONE);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("upcoming");
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
            location_info = view.findViewById(R.id.location_text);

            EventsData eventsData = eventsDataList.get(i);
            Picasso.get().load(eventsData.getImageUrl()).into(eventimageview);

            titleview.setText(eventsData.getTitle());
            categoryview.setText(eventsData.getCategory());
            dateview.setText(eventsData.getDate());
            racesview.setText(eventsData.getRaces());
            location_info.setText(eventsData.getLocation());

            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_right);
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
                    }
                    else if (arg2 == 1){
                        eventid = 1;
                        title = dataSnapshot.child("02").child("title").getValue().toString();
                    }
                    else if (arg2 == 2){
                        eventid = 2;
                        title = dataSnapshot.child("03").child("title").getValue().toString();
                    }
                    Fragment fragment = new UpcomingEventInfoFragment();
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
