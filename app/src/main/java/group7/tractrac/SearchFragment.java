package group7.tractrac;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.tabs.Clubs_tab;
import group7.tractrac.tabs.Events_tab;
import group7.tractrac.tabs.Relevant_tab;
import group7.tractrac.tabs.SectionsAdapter;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

private ListView listView;
private ArrayList <SearchListItems> arrayList;
SearchListItems searchListItems;

private static final String  TAG = "Main";
private SectionsAdapter sectionsAdapter;
private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflaterview = inflater.inflate(R.layout.fragment_search, container, false);

        sectionsAdapter = new SectionsAdapter(getFragmentManager());

        viewPager = inflaterview.findViewById(R.id.container);
        setUpAdapter(viewPager);

        TabLayout tabLayout = inflaterview.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

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

}
