package group7.tractrac.tabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.SearchView;

import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.CostumList.Search_ListAdapter;
import group7.tractrac.R;

import java.util.ArrayList;

public class Relevant_tab extends Fragment {

    private ListView listView;
    private ArrayList <SearchListItems> arrayList;
    ArrayList<SearchListItems> test;
    SearchListItems searchListItems;
    public Search_ListAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Relevant", "onCreateView:");
        View inflaterview = inflater.inflate(R.layout.fragment_relevant_tab, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            test = bundle.getParcelableArrayList("ReleventArrayList");
            Log.d("test filen", String.valueOf(test.size()));
            if (test != null) {


                listView = inflaterview.findViewById(R.id.RelevantTabList);
                listAdapter = new Search_ListAdapter(getContext(),R.layout.costume_search_list,test);
                listView.setAdapter(listAdapter);
            }
        }
/*
        else {
            listView = inflaterview.findViewById(R.id.RelevantTabList);
            setUpList();}
            */



        return inflaterview;
    }
/*
    void setUpList (){

        arrayList = new ArrayList<>();

        String mDrawableName = "ess";
        Resources res = getResources();

        searchListItems = new SearchListItems(R.drawable.ess,"Relevant test","Relevant endny en test");

        arrayList.add(searchListItems);
        searchListItems = new SearchListItems(R.drawable.eurosail,"Sailing","Relevant");

        arrayList.add(searchListItems);
        listAdapter = new Search_ListAdapter(getContext(),R.layout.costume_search_list,arrayList);

        listView.setAdapter(listAdapter);
    }
    */

}
