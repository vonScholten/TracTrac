package group7.tractrac;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PastEventInfoFragment extends Fragment {
    TextView eventTitle;
    ImageView eventImg;
    String title;
    private DatabaseReference databaseReference;
    private List<EventsData> eventsDataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_past_event_info, container, false);
        getView(inflaterview);
        eventTitle = inflaterview.findViewById(R.id.event_info_title);
        eventImg = inflaterview.findViewById(R.id.event_image);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("past");

        setTitle();

        return inflaterview;
    }


    private void setTitle() {
        if (PastEventsFragment.eventid == 0){
            eventTitle.setText(PastEventsFragment.title);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    eventsDataList.clear();
                    for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                        EventsData eventsData = postSnapShot.getValue(EventsData.class);
                        eventsDataList.add(eventsData);
                    }

                    EventsData eventsData = eventsDataList.get(PastEventsFragment.eventid);
                    Picasso.get().load(eventsData.getImageUrl()).into(eventImg);
                    //titleview.setText(eventsData.getTitle());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        }
        else
        if (PastEventsFragment.eventid == 1){
            eventTitle.setText(PastEventsFragment.title);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    eventsDataList.clear();
                    for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                        EventsData eventsData = postSnapShot.getValue(EventsData.class);
                        eventsDataList.add(eventsData);
                    }

                    EventsData eventsData = eventsDataList.get(PastEventsFragment.eventid);
                    Picasso.get().load(eventsData.getImageUrl()).into(eventImg);
                    //titleview.setText(eventsData.getTitle());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });
        }

        else
        if (PastEventsFragment.eventid == 2){
            eventTitle.setText(PastEventsFragment.title);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    eventsDataList.clear();
                    for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                        EventsData eventsData = postSnapShot.getValue(EventsData.class);
                        eventsDataList.add(eventsData);
                    }

                    EventsData eventsData = eventsDataList.get(PastEventsFragment.eventid);
                    Picasso.get().load(eventsData.getImageUrl()).into(eventImg);
                    //titleview.setText(eventsData.getTitle());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });
        }
    }


    public View getView(View view) {
        TextView eventInfoTitle = view.findViewById(R.id.event_info_title);
/**
 switch (EventFragment.eventid) {
 case 0: eventInfoTitle.setText(R.string.event_french);

 break;
 case 1: eventInfoTitle.setText(R.string.event_swiss);
 break;
 case 2: eventInfoTitle.setText(R.string.event_ess);
 break;
 case 3: eventInfoTitle.setText(R.string.event_eurosail);
 break;
 case 4: eventInfoTitle.setText(R.string.event_redbull);
 break;
 default: eventInfoTitle.setText("Event");
 break;
 }
 **/

        return view;
    }

}
