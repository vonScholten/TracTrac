package group7.tractrac.tabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.*;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.CostumList.Search_ListAdapter;
import group7.tractrac.EventsData;
import group7.tractrac.PastEventsFragment;
import group7.tractrac.R;
import group7.tractrac.UpcomingEventsFragment;
import group7.tractrac.tabs.Clubs_tab;
import group7.tractrac.tabs.Events_tab;
import group7.tractrac.tabs.Relevant_tab;
import group7.tractrac.tabs.SectionsAdapter;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

private ListView listView;
private ArrayList <SearchListItems> arrayList;
private ArrayList<SearchListItems> currentArrayList;
private SearchListItems searchListItems;

private DatabaseReference dbReference;
private ArrayList<EventsData> eventsData;

private ArrayList<SearchListItems> releventList;
private ArrayList<SearchListItems> eventList;
private ArrayList<SearchListItems> clubsList;

private static final String  TAG = "Main";
private SectionsAdapter sectionsAdapter;
private ViewPager viewPager;
private Search_ListAdapter listAdapter;
private View inflaterview;
Relevant_tab relevant_tab = new Relevant_tab();
private TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflaterview = inflater.inflate(R.layout.fragment_search, container, false);

        SearchView searchView = (SearchView) inflaterview.findViewById(R.id.searchSearch);
        viewPager = (ViewPager) inflaterview.findViewById(R.id.viewcontainer);

        relevant_tab = new Relevant_tab();
        sectionsAdapter = new SectionsAdapter(getFragmentManager());

        eventsData = new ArrayList<>();
        releventList = new ArrayList<>();

       // createBundle();



        dbReference = FirebaseDatabase.getInstance().getReference("upcoming");
        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventsData.clear();
                Log.d("Virker download","yes/no");
                for(DataSnapshot postSnapShot : dataSnapshot.getChildren()){
                    EventsData eventsDataL = postSnapShot.getValue(EventsData.class);
                    eventsData.add(eventsDataL);
                }

                for (int i = 0; i < eventsData.size(); i++) {
                    searchListItems = new SearchListItems(R.drawable.ess, eventsData.get(i).getTitle(),"Event");
                    releventList.add(searchListItems);
                }
                createBundle(releventList);
                FragmentManager manager = getFragmentManager();

                //viewPager.getAdapter().
                //manager.beginTransaction().replace(R.id.RelevanteID,relevant_tab).commit();
                setUpViewPager(viewPager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        tabLayout = (TabLayout) inflaterview.findViewById(R.id.searchTabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Log.d(TAG, "onTabSelected: 0 ");
                        /**
                         * Tror at fragmentets view ikke bliver åbnet korrekt.
                         * Kan være fordi "ViewPager" åbner dem i viewContainer....
                         *
                         */
                        //createBundle(releventList);
                        //FragmentManager manager = getFragmentManager();
                        //manager.beginTransaction().replace(R.id.RelevanteID,relevant_tab).commit();
                        break;
                    case 1:
                        Log.d(TAG, "onTabSelected: 1");
                        break;
                    case 2:
                        Log.d(TAG, "onTabSelected: 2 ");
                        break;
                    default:
                        Log.d(TAG, "onTabSelected: no tab selected ");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("text", "Hello!");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //createBundle();
              //  FragmentManager manager = getFragmentManager();
               // manager.beginTransaction().replace(R.id.RelevanteID,relevant_tab).commit();


                /**
                 * Prøv at kigge på pageadapter.startUpdate
                 * */
                createBundle(testList());
                viewPager.setAdapter(null);
                setUpViewPager(viewPager);
                Log.d("textchange", "Hello, Bitches!");
                return false;
            }
        });
        //Creates the fragments when collecting data is done
        //setUpViewPager(viewPager);
        return  inflaterview;
    }

    private void setUpViewPager (ViewPager pager ) {
        Log.d("SetupView", "setUpView: ");
        SectionsAdapter adapter = new SectionsAdapter(getFragmentManager());

        //Old
        //adapter.addFragment(new Relevant_tab(), "RELEVANT");
        //New
        adapter.addFragment(relevant_tab, "RELEVANT");
        adapter.addFragment(new Events_tab(), "EVENTS");
        adapter.addFragment(new Clubs_tab(), "CLUBS");
        pager.setAdapter(adapter);
    }

    private void createBundle (ArrayList<SearchListItems> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("arraylistTest",arrayList);
        relevant_tab.setArguments(bundle);
    }

    private ArrayList testList () {
        arrayList = new ArrayList<>();
        searchListItems = new SearchListItems(R.drawable.ess,"Relevant test","Relevant endny en test");
        arrayList.add(searchListItems);
        searchListItems = new SearchListItems(R.drawable.eurosail,"Sailing","Relevant");
        arrayList.add(searchListItems);
        return arrayList;
    }

}
