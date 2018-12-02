package group7.tractrac;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class EventFragment extends Fragment implements AdapterView.OnItemClickListener {

    TextView titleview;
    TextView categoryview;
    TextView dateview;
    TextView racesview;
    TextView participantsview;
    ImageView eventimageview;
    public static int eventid = 0;
    private DatabaseReference databaseReference;
    private List<EventsData> eventsDataList;

    ListView events;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_event, container, false);
        events = inflaterview.findViewById(R.id.eventlist);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("events");
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

        events.setOnItemClickListener((AdapterView.OnItemClickListener) this);


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
            participantsview = view.findViewById(R.id.participants);

            EventsData eventsData = eventsDataList.get(i);
            Picasso.get().load(eventsData.getImageUrl()).into(eventimageview);

            titleview.setText(eventsData.getTitle());
            categoryview.setText(eventsData.getCategory());
            dateview.setText(eventsData.getDate());
            racesview.setText(eventsData.getRaces());
            participantsview.setText(eventsData.getParticipants());


            return view;
        }
    }


    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // arg2 = the id of the item in our view (List/Grid) that we clicked
        // arg3 = the id of the item that we have clicked
        // if we didn't assign any id for the Object (Book) the arg3 value is 0
        // That means if we comment, aBookDetail.setBookIsbn(i); arg3 value become 0

        if (arg2 == 0){
            eventid = 0;
        }
        else if (arg2 == 1){
            eventid = 1;
        }
        else if (arg2 == 2){
            eventid = 2;
        }
        else if (arg2 == 3){
            eventid = 3;
        }
        else if (arg2 == 04){
            eventid = 4;
        }

        Fragment fragment = new EventInfoFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentFrame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
