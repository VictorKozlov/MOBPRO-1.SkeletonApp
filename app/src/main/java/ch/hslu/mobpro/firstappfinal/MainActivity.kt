package ch.hslu.mobpro.firstappfinal


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.hslu.mobpro.firstappfinal.overview.OverviewFragment

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
				.add(R.id.fragment_host, OverviewFragment.newInstance())
				.commit()
		}
	}

}