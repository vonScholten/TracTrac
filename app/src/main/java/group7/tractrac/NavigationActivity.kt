package group7.tractrac

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import com.crashlytics.android.Crashlytics
import group7.tractrac.R.id
import group7.tractrac.R.layout
import group7.tractrac.home.HomeFragment
import group7.tractrac.tabs.Search_Activity
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_navigation.*


class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            id.navigation_home -> {

                navigateHome()
                return@OnNavigationItemSelectedListener true
            }
            id.navigation_events -> {

                navigateEvents()
                return@OnNavigationItemSelectedListener true
            }
            id.navigation_clubs -> {

                navigateClubs()
                return@OnNavigationItemSelectedListener true
            }
            id.navigation_profile -> {

                navigateProfil()
                return@OnNavigationItemSelectedListener true
            }
            id.navigation_search -> {

                navigateSearch()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_navigation)
        Fabric.with(this, Crashlytics())

        //setSupportActionBar(findViewById(R.id.tractrac_toolbar))

        //supportActionBar?.title = ""
        //supportActionBar?.setLogo(R.mipmap.ic_launcher_foreground)
        //supportActionBar?.setDisplayUseLogoEnabled(true)

        //val actionBar = getActionBar()

        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeButtonEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val inflator = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflator.inflate(R.layout.custom_actionbar, null)

        supportActionBar?.setCustomView(v)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        navigateHome()
    }

    fun navigateHome() {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        val transaction = manager.beginTransaction()
        val fragment = HomeFragment()

        transaction.replace(id.fragmentFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun navigateEvents() {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        val transaction = manager.beginTransaction()
        val fragment = EventFragment()

        transaction.replace(id.fragmentFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun navigateClubs() {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        val transaction = manager.beginTransaction()
        val fragment = Clubs_Fragment()

        transaction.replace(id.fragmentFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun navigateSettings() {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        val transaction = manager.beginTransaction()
        val fragment = Settings_Fragment()

        transaction.replace(id.fragmentFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun navigateSearch() {
        /*
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        val transaction = manager.beginTransaction()
        val fragment = SearchFragment()

        transaction.replace(id.fragmentFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        */
        //Intent intent = new Intent(this, user);

        val intent = Intent(this, Search_Activity::class.java)

        startActivity(intent);
       // setContentView(R.layout.)
    }

    fun navigateProfil() {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        val transaction = manager.beginTransaction()
        val fragment = LoginFragment()

        transaction.replace(id.fragmentFrame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
