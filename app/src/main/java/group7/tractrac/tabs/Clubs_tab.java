package group7.tractrac.tabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import group7.tractrac.CostumList.SearchListItems;
import group7.tractrac.CostumList.Search_ListAdapter;
import group7.tractrac.R;

import java.util.ArrayList;


public class Clubs_tab extends Fragment {
    private ListView listView;
    private ArrayList<SearchListItems> arrayList;
    SearchListItems searchListItems;
    public Search_ListAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflaterview = inflater.inflate(R.layout.fragment_clubs_tab, container, false);

        listView = inflaterview.findViewById(R.id.ClubsTabList);

        Bundle bundle = getArguments();

        if (bundle != null) {
            arrayList = bundle.getParcelableArrayList("ClubsArrayList");
            Log.d("test filen", String.valueOf(arrayList.size()));
            if (arrayList != null) {


                listView = inflaterview.findViewById(R.id.ClubsTabList);
                listAdapter = new Search_ListAdapter(getContext(),R.layout.costume_search_list,arrayList);
                listView.setAdapter(listAdapter);
            }
        }

        return inflaterview;
    }

    void setUpList (){

        arrayList = new ArrayList<>();

        String mDrawableName = "ess";
        Resources res = getResources();

        searchListItems = new SearchListItems(R.drawable.ess,"Clubs test","Clubs endny en test");

        arrayList.add(searchListItems);
        searchListItems = new SearchListItems(R.drawable.eurosail,"Sailing","Clubs");

        arrayList.add(searchListItems);
        Search_ListAdapter listAdapter = new Search_ListAdapter(getContext(),R.layout.costume_search_list,arrayList);

        listView.setAdapter(listAdapter);


    }
}
