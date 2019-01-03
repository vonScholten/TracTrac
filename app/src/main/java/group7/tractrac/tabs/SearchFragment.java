package group7.tractrac.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.*;
import android.widget.ListView;
import android.widget.SearchView;
import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.CostumList.Search_ListAdapter;
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
        inflaterview = inflater.inflate(R.layout.fragment_search, container, false);
        sectionsAdapter = new SectionsAdapter(getFragmentManager());

        ViewPager viewPager = (ViewPager) inflaterview.findViewById(R.id.viewcontainer);
        setUpViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) inflaterview.findViewById(R.id.searchTabs);
        tabLayout.setupWithViewPager(viewPager);

        SearchView searchView = (SearchView) inflaterview.findViewById(R.id.searchSearch);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("text", "Hello!");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("textchange", "Hello, Bitches!");
                return false;
            }
        });

        return  inflaterview;
    }

    private void setUpViewPager (ViewPager pager ) {
        Log.d("SetupView", "setUpView: ");
        SectionsAdapter adapter = new SectionsAdapter(getFragmentManager());
        adapter.addFragment(new Relevant_tab(), "RELEVANT");
        adapter.addFragment(new Events_tab(), "EVENTS");
        adapter.addFragment(new Clubs_tab(), "CLUBS");
        pager.setAdapter(adapter);
    }
}
