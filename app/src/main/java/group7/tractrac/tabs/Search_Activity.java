package group7.tractrac.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import group7.tractrac.R;
import group7.tractrac.SearchActivity.SectionsPagerAdapter;

public class Search_Activity extends AppCompatActivity {
    private static final String TAG = "Search_Activity";
    private SectionsPagerAdapter sectionsAdapter;
    private FragmentManager fragmentManager;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        Log.d("Activity", "Search: ");
        sectionsAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container01);
        setUpViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager (ViewPager pager ) {
        Log.d("SetupView", "setUpView: ");
        SectionsAdapter adapter = new SectionsAdapter(getSupportFragmentManager());
        adapter.addFragment(new Relevant_tab(), "RELEVANT");
        adapter.addFragment(new Events_tab(), "EVENTS");
        adapter.addFragment(new Clubs_tab(), "CLUBS");
        pager.setAdapter(adapter);
    }
}
