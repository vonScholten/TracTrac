package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class EventFragment extends Fragment {

    int[] images = {R.drawable.french, R.drawable.swiss, R.drawable.ess, R.drawable.eurosail, R.drawable.redbull};

    String[] title = {"French sailing league","Swiss sailing league","ESS San Diego 2018",
            "Eurosail 2018", "Red Bull conquer the castle"};
    String[] category = {"Sailing", "Sailing", "Sailing", "Sailing", "Adventure and multisport"};
    String[] date = {"19 November", "21 November", "27 November", "29 November", "12 December"};

    String[] races = {"races: 14", "races: 32", "races: 45", "races: 21", "races: 12"};
    String[] participants = {"Participants: 27", "Participants: 18", "Participants: 32", "Participants: 23", "Participants: 61"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflaterview = inflater.inflate(R.layout.fragment_event, container, false);

        ListView events = inflaterview.findViewById(R.id.eventlist);
        CustomAdapter eventadapter = new CustomAdapter();
        events.setAdapter(eventadapter);
        return inflaterview;
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.custom_layout_events, null);
            ImageView eventimageview = view.findViewById(R.id.eventimage);
            TextView titleview =  view.findViewById(R.id.title);
            TextView categoryview = view.findViewById(R.id.category);
            TextView dateview = view.findViewById(R.id.date);
            TextView racesview = view.findViewById(R.id.races);
            TextView participantsview = view.findViewById(R.id.participants);

            eventimageview.setImageResource(images[i]);
            titleview.setText(title[i]);
            categoryview.setText(category[i]);
            dateview.setText(date[i]);
            racesview.setText(races[i]);
            participantsview.setText(participants[i]);

            return view;
        }
    }

}
