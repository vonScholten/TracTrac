package group7.tractrac.tabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.CostumList.Search_ListAdapter;
import group7.tractrac.R;

import java.util.ArrayList;

public class Relevant_tab extends Fragment {

    private ListView listView;
    private ArrayList <SearchListItems> arrayList;
    SearchListItems searchListItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflaterview = inflater.inflate(R.layout.fragment_relevant_tab, container, false);

        listView = inflaterview.findViewById(R.id.RelevantTabList);
        setUpList();

        return inflaterview;
    }


    void setUpList (){

        arrayList = new ArrayList<>();

        String mDrawableName = "ess";
        Resources res = getResources();

        searchListItems = new SearchListItems(R.drawable.ess,"Relevant test","Relevant endny en test");

        arrayList.add(searchListItems);
        searchListItems = new SearchListItems(R.drawable.eurosail,"Sailing","Relevant");

        arrayList.add(searchListItems);
        Search_ListAdapter listAdapter = new Search_ListAdapter(getContext(),R.layout.costume_search_list,arrayList);

        listView.setAdapter(listAdapter);
    }
}
