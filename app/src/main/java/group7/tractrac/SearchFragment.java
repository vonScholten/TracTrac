package group7.tractrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.ListView;
import android.widget.SearchView;
import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.CostumList.Search_ListAdapter;
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
private SearchView searchView;

private static final String  TAG = "Main";
private SectionsAdapter sectionsAdapter;
private ViewPager viewPager;
    Search_ListAdapter listAdapter;
    View inflaterview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        inflaterview = inflater.inflate(R.layout.fragment_search, container, false);

        listView = (ListView) inflaterview.findViewById(R.id.searchList);

        arrayList = new ArrayList<>();

        setupList();

       // sectionsAdapter = new SectionsAdapter(getFragmentManager());

       // viewPager = inflaterview.findViewById(R.id.container);

        //setUpAdapter(viewPager);

        //TabLayout tabLayout = inflaterview.findViewById(R.id.tabs);
        //tabLayout.setupWithViewPager(viewPager);

        // if need it can be added again, but prob not gonna happen.

        return  inflaterview;
    }

    private void setUpAdapter(ViewPager viewPager) {
        SectionsAdapter adapter = new SectionsAdapter(getFragmentManager());
        adapter.addFragment(new Relevant_tab(), "RelevantTab");
        adapter.addFragment(new Events_tab(),"EventsTab");
        adapter.addFragment(new Clubs_tab(),"ClubsTab");
        viewPager.setAdapter(adapter);
    }

    void setupList () {
        // searchListItems.event = "test01";
        // searchListItems.eventName = "EventTest01";
        //  searchListItems.imageView = R.drawable.eurosail;
        //  arrayList.add(searchListItems);

        searchListItems = new SearchListItems(R.drawable.ess,"Relevant test","Event");

        arrayList.add(searchListItems);

        searchListItems = new SearchListItems(R.drawable.eurosail,"Sailing","Event");

        arrayList.add(searchListItems);

        searchListItems = new SearchListItems(R.drawable.eurosail,"Running","Event");

        arrayList.add(searchListItems);

        searchListItems = new SearchListItems(R.drawable.eurosail,"SuperRunning","Event");

        arrayList.add(searchListItems);

        searchListItems = new SearchListItems(R.drawable.eurosail,"SuperRunning","Club");


        arrayList.add(searchListItems);

        searchListItems = new SearchListItems(R.drawable.eurosail,"SuperRunning","Club");

        arrayList.add(searchListItems);


        listAdapter = new Search_ListAdapter(getContext(),R.layout.costume_search_list, arrayList);

        listView.setAdapter(listAdapter);
    }

    void sortList () {


        //searchView.getQuery();


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_search, menu);

        //Old code
        /*
        Log.d("inflater", String.valueOf(inflater));

        MenuItem menuItem = menu.findItem(R.id.searchList);

        Log.d("Test", String.valueOf(menu));

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                listAdapter.getFilter().filter(s);
                return false;
            }
        }); */

        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }



}
