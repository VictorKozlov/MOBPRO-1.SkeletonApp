package ch.hslu.mobpro.firstappfinal.lifecyclelog

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ch.hslu.mobpro.firstappfinal.R


class LifecycleLogActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_lifecycle_logger)
		Log.i("hslu_mobApp", "Activity onCreate() aufgerufen")
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
				.add(
					R.id.fragment_host,
					LifecycleLogFragment.newInstance()
				)
				.commit()
		}
	}

	override fun onStart() {
		super.onStart()

		Log.i("hslu_mobApp", "Activity onStart() aufgerufen")
	}

	override fun onRestart() {
		super.onRestart()

		Log.i("hslu_mobApp", "Activity onRestart() aufgerufen")
	}

	override fun onResume() {
		super.onResume()

		Log.i("hslu_mobApp", "Activity onResume() aufgerufen")
	}

	override fun onPause() {
		super.onPause()

		Log.i("hslu_mobApp", "Activity onPause() aufgerufen")
	}

	override fun onDestroy() {
		super.onDestroy()

		Log.i("hslu_mobApp", "Activity onDestroy() aufgerufen")
	}
}