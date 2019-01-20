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
    TextView description;
    TextView date;
    TextView location;
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
        description = inflaterview.findViewById(R.id.description_id);
        date = inflaterview.findViewById(R.id.date_info);
        location = inflaterview.findViewById(R.id.location_info);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("upcoming");

        setTitle();

        return inflaterview;
    }


    private void setTitle() {
        eventTitle.setText(UpcomingEventsFragment.title);
        description.setText(UpcomingEventsFragment.description);
        date.setText(UpcomingEventsFragment.date);
        location.setText(UpcomingEventsFragment.location);
        if (UpcomingEventsFragment.eventid == 0){

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
