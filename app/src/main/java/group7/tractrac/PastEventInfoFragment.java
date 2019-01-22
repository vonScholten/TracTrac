package group7.tractrac;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PastEventInfoFragment extends Fragment {
    TextView eventTitle;
    TextView date_past;
    TextView location_past;
    ImageView eventImg;
    ImageView play;
    ImageView trophy;
    ImageView flag;
    VideoView video;
    String title;
    private DatabaseReference databaseReference;
    private List<EventsData> eventsDataList;
    ListView videoList;
    TextView racesnum;

    PopupWindow Player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_past_event_info, container, false);
        eventTitle = inflaterview.findViewById(R.id.event_info_title);
        date_past = inflaterview.findViewById(R.id.date_info);
        location_past = inflaterview.findViewById(R.id.location_info);
        eventImg = inflaterview.findViewById(R.id.event_image);
        video = inflaterview.findViewById(R.id.videoId);

        eventsDataList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("past");

        setTitle();

        videoList = inflaterview.findViewById(R.id.video_list);
        VideoAdapter videoAdapter = new VideoAdapter();
        videoList.setAdapter(videoAdapter);

        return inflaterview;
    }


    private void setTitle() {

        eventTitle.setText(PastEventsFragment.title);
        date_past.setText(PastEventsFragment.date);
        location_past.setText(PastEventsFragment.location);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventsDataList.clear();
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
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

    class VideoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            long tempracenr;
            if (PastEventsFragment.racesnr == 0){
                tempracenr = 1;
                return  (int) tempracenr;
            }
            else {
                return (int) PastEventsFragment.racesnr;
            }
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout_video_list, null);
            play = view.findViewById(R.id.playicon);
            trophy = view.findViewById(R.id.trophy);
            flag = view.findViewById(R.id.flagicon);
            trophy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Wip: Display placement list for race", Toast.LENGTH_SHORT).show();
                }
            });
            play.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent videoIntent = new Intent(getActivity(), VideoActivity.class);
                    startActivity(videoIntent);
                }
            }
            );

            long test;
            test = PastEventsFragment.racesnr;
            racesnum = view.findViewById(R.id.racenr);
            if (test == 0){
                play.setVisibility(View.INVISIBLE);
                trophy.setVisibility(View.INVISIBLE);
                flag.setVisibility(View.GONE);
                racesnum.setText("No races yet");
            }
            else {
                    racesnum.setText("Race " + (i + 1));
            }


            return view;
        }
    }

}



