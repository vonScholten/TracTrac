package group7.tractrac;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class EventFragment extends Fragment {

    private TabLayout tablayout;
    private AppBarLayout appbarlayout;
    private ViewPager viewpager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflaterview = inflater.inflate(R.layout.fragment_event, container, false);


        tablayout = inflaterview.findViewById(R.id.tabs);
        appbarlayout =  inflaterview.findViewById(R.id.appbar);
        viewpager = inflaterview.findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.AddFragment(new UpcomingEventsFragment(), "Upcoming");
        adapter.AddFragment(new PastEventsFragment(), "Past");

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        UpcomingEventsFragment upcomingFragment = new UpcomingEventsFragment();
        transaction.replace(R.id.fragment_container_events, upcomingFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {



            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                UpcomingEventsFragment upcomingFragment = new UpcomingEventsFragment();
                PastEventsFragment pastFragment = new PastEventsFragment();

                switch (tab.getPosition()) {
                    case 0:
                            transaction.replace(R.id.fragment_container_events, upcomingFragment);

                        break;

                    case 1:
                            transaction.replace(R.id.fragment_container_events, pastFragment);
                        break;
                }
                transaction.addToBackStack(null);
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                UpcomingEventsFragment upcomingFragment = new UpcomingEventsFragment();
                PastEventsFragment pastFragment = new PastEventsFragment();
                switch (tab.getPosition()) {
                    case 0:
                            transaction.replace(R.id.fragment_container_events, upcomingFragment);
                        break;
                    case 1:
                            transaction.replace(R.id.fragment_container_events, pastFragment);
                        break;

                }
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return inflaterview;
    }

}


