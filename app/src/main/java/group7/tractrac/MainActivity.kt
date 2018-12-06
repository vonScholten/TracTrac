package group7.tractrac

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fabric = Fabric.Builder(this)
            .kits(Crashlytics())
            .debuggable(true)
            .build()
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)


    }
}
