package group7.tractrac.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import group7.tractrac.R;

public class Search_Activity extends AppCompatActivity {
    private static final String TAG = "Search_Activity";
    private SectionsAdapter sectionsAdapter;
    private FragmentManager fragmentManager;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        Log.d("Activity", "Search: ");
        sectionsAdapter= new SectionsAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container01);
        setUpViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        SearchView searchView = (SearchView) findViewById(R.id.searchbar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d(" On Qu", "onQueryTextSubmit: ");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d(" On Qu", "onQueryTextSubmit: ");
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {

        Log.d("OncreateOption","test");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.menu.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    return super.onCreateOptionsMenu(menu);

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
