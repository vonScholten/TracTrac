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


public class UpcomingEventInfoFragment extends Fragment {
    TextView eventTitle;
    ImageView eventImg;
    String title;
    private DatabaseReference databaseReference;
    private List<EventsData> eventsDataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_upcoming_event_info, container, false);
        eventTitle = inflaterview.findViewById(R.id.event_info_title);
        eventImg = inflaterview.findViewById(R.id.event_image);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("upcoming");

        setTitle();

        return inflaterview;
    }


    private void setTitle() {
        if (UpcomingEventsFragment.eventid == 0){
            eventTitle.setText(UpcomingEventsFragment.title);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    eventsDataList.clear();
                    for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                        EventsData eventsData = postSnapShot.getValue(EventsData.class);
                        eventsDataList.add(eventsData);
                    }

                    EventsData eventsData = eventsDataList.get(UpcomingEventsFragment.eventid);
                    Picasso.get().load(eventsData.getImageUrl()).into(eventImg);
                    //titleview.setText(eventsData.getTitle());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        }
        else
            if (UpcomingEventsFragment.eventid == 1){
                eventTitle.setText(UpcomingEventsFragment.title);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        eventsDataList.clear();
                        for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                            EventsData eventsData = postSnapShot.getValue(EventsData.class);
                            eventsDataList.add(eventsData);
                        }

                        EventsData eventsData = eventsDataList.get(UpcomingEventsFragment.eventid);
                        Picasso.get().load(eventsData.getImageUrl()).into(eventImg);
                        //titleview.setText(eventsData.getTitle());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }

            else
            if (UpcomingEventsFragment.eventid == 2){
                eventTitle.setText(UpcomingEventsFragment.title);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        eventsDataList.clear();
                        for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                            EventsData eventsData = postSnapShot.getValue(EventsData.class);
                            eventsDataList.add(eventsData);
                        }

                        EventsData eventsData = eventsDataList.get(UpcomingEventsFragment.eventid);
                        Picasso.get().load(eventsData.getImageUrl()).into(eventImg);
                        //titleview.setText(eventsData.getTitle());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
    }

    }
