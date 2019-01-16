package group7.tractrac.tabs;

import android.os.Bundle;

import java.util.ArrayList;

import group7.tractrac.CostumList.SearchListItems;

public class CreateBundle {


    public CreateBundle () {

    }

    public void createReleventBundle(ArrayList<SearchListItems> arrayList, Relevant_tab relevant_tab) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ReleventArrayList", arrayList);
        relevant_tab.setArguments(bundle);
    }

    public void createClubBundle(ArrayList<SearchListItems> arrayList, Clubs_tab clubs_tab) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ClubsArrayList", arrayList);
        clubs_tab.setArguments(bundle);

    }

    public void createEventBundle(ArrayList<SearchListItems> arrayList, Events_tab events_tab) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("EventArrayList", arrayList);
        events_tab.setArguments(bundle);

    }
}
