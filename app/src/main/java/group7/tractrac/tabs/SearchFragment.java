package group7.tractrac.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.google.firebase.database.*;
import group7.tractrac.ClubsData;
import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.EventsData;
import group7.tractrac.R;

import java.util.ArrayList;
import java.util.Collections;


public class SearchFragment extends Fragment {


    private SearchListItems searchListItems;

    private DatabaseReference dbReference;
    private ArrayList<EventsData> eventsData;
    private ArrayList<ClubsData> clubsData;

    private ArrayList<SearchListItems> releventList;
    private ArrayList<SearchListItems> eventList;
    private ArrayList<SearchListItems> clubsList;

    private static final String TAG = "Main";
    private SectionsAdapter sectionsAdapter;
    private ViewPager viewPager;

    private int lastPage = 0;
    private View inflaterview;

    Relevant_tab relevant_tab = new Relevant_tab();
    Clubs_tab clubs_tab = new Clubs_tab();
    Events_tab events_tab = new Events_tab();


    private TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflaterview = inflater.inflate(R.layout.fragment_search, container, false);

        SearchView searchView = inflaterview.findViewById(R.id.searchSearch);
        viewPager = inflaterview.findViewById(R.id.viewcontainer);

        final CreateBundle createBundle = new CreateBundle();
        sectionsAdapter = new SectionsAdapter(getFragmentManager());


        eventsData = new ArrayList<>();
        clubsData = new ArrayList<>();
        releventList = new ArrayList<>();
        eventList = new ArrayList<>();
        clubsList = new ArrayList<>();

        // createBundle();

        dbReference = FirebaseDatabase.getInstance().getReference("upcoming");
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventsData.clear();
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    EventsData eventsDataL = postSnapShot.getValue(EventsData.class);
                    eventsData.add(eventsDataL);
                }

                for (int i = 0; i < eventsData.size(); i++) {
                    searchListItems = new SearchListItems(eventsData.get(i).getImageUrl(), eventsData.get(i).getTitle(), "Event");
                    eventList.add(searchListItems);
                    releventList.add(searchListItems);
                }

                dbReference = FirebaseDatabase.getInstance().getReference("clubs");
                dbReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        clubsData.clear();
                        for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                            ClubsData clubsDataL = postSnapShot.getValue(ClubsData.class);
                            clubsData.add(clubsDataL);
                        }

                        for (int i = 0; i < clubsData.size(); i++) {
                            searchListItems = new SearchListItems(clubsData.get(i).getUrl(), clubsData.get(i).getName(), "Club");
                            if (searchListItems == null) {
                                Log.d("SEarchList", String.valueOf(searchListItems));
                            }
                            Log.d("clubs", String.valueOf(clubsList));
                            clubsList.add(searchListItems);
                            /**
                             * Error Null object reference
                             * */
                            releventList.add(searchListItems);
                        }
                        Collections.shuffle(releventList);
                        createBundle.createReleventBundle(releventList, relevant_tab);
                        createBundle.createEventBundle(eventList,events_tab);
                        createBundle.createClubBundle(clubsList,clubs_tab);

                        setUpViewPager(viewPager);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        tabLayout = inflaterview.findViewById(R.id.searchTabs);
        tabLayout.setupWithViewPager(viewPager);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("text", "Hello!");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if (s.isEmpty()) {
                    createBundle.createReleventBundle(releventList, relevant_tab);
                    createBundle.createEventBundle(eventList,events_tab);
                    createBundle.createClubBundle(clubsList,clubs_tab);
                    lastPage = viewPager.getCurrentItem();
                    viewPager.setAdapter(null);
                    setUpViewPager(viewPager);
                    viewPager.setCurrentItem(lastPage);

                } else {
                    createBundle.createReleventBundle(sortArray(releventList, s), relevant_tab);
                    createBundle.createEventBundle(sortArray(eventList,s),events_tab);
                    createBundle.createClubBundle(sortArray(clubsList,s),clubs_tab);
                    lastPage = viewPager.getCurrentItem();
                    viewPager.setAdapter(null);
                    setUpViewPager(viewPager);

                    /**
                     * Sets what page to start on
                     * */
                    viewPager.setCurrentItem(lastPage);

                    Log.d("textchange", "Hello, Bitches!");
                }
                return false;
            }
        });
        //Creates the fragments when collecting data is done
        //setUpViewPager(viewPager);
        return inflaterview;
    }

    private void setUpViewPager(ViewPager pager) {
        Log.d("SetupView", "setUpView: ");
        SectionsAdapter adapter = new SectionsAdapter(getFragmentManager());

        adapter.addFragment(relevant_tab, "RELEVANT");
        adapter.addFragment(events_tab, "EVENTS");
        adapter.addFragment(clubs_tab, "CLUBS");
        pager.setAdapter(adapter);
    }

    private ArrayList sortArray(ArrayList<SearchListItems> current, String string) {
        ArrayList<SearchListItems> newArray = new ArrayList<SearchListItems>();
        String arrayText;
        for (int i = 0; i < current.size(); i++) {
            arrayText = current.get(i).eventName.toLowerCase();
            if (arrayText.contains(string.toLowerCase())) {
                newArray.add(current.get(i));
            }
        }
        return newArray;
    }


}
