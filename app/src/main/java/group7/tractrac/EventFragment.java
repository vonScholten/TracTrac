package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class EventFragment extends Fragment implements AdapterView.OnItemClickListener {

    TextView titleview;
    TextView categoryview;
    TextView dateview;
    TextView racesview;
    TextView participantsview;
    ImageView eventimageview;
    public static int eventid = 0;

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
        events.setOnItemClickListener((AdapterView.OnItemClickListener) this);


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
            eventimageview = view.findViewById(R.id.eventimage);
            titleview =  view.findViewById(R.id.title);
            categoryview = view.findViewById(R.id.category);
            dateview = view.findViewById(R.id.date);
            racesview = view.findViewById(R.id.races);
            participantsview = view.findViewById(R.id.participants);

            eventimageview.setImageResource(images[i]);
            titleview.setText(title[i]);
            categoryview.setText(category[i]);
            dateview.setText(date[i]);
            racesview.setText(races[i]);
            participantsview.setText(participants[i]);

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
