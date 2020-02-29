package ch.hslu.mobpro.firstappfinal.lifecyclelog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ch.hslu.mobpro.firstappfinal.R

class LifecycleLogFragment : Fragment(R.layout.fragment_lifecycle_logger) {

	companion object {
		fun newInstance(): LifecycleLogFragment {
			return LifecycleLogFragment()
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Log.i("hslu_mobApp", "Fragment onCreate() aufgerufen")
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		Log.i("hslu_mobApp", "Fragment onCreateView() aufgerufen")
		return super.onCreateView(inflater, container, savedInstanceState)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.i("hslu_mobApp", "Fragment onViewCreated() aufgerufen")
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		Log.i("hslu_mobApp", "Fragment onActivityCreated() aufgerufen")
	}

	//On Start doesnt exist

	override fun onResume() {
		super.onResume()
		Log.i("hslu_mobApp", "Fragment onResume() aufgerufen")
	}

	override fun onPause() {
		super.onPause()
		Log.i("hslu_mobApp", "Fragment onPause() aufgerufen")
	}

	override fun onStop() {
		super.onStop()
		Log.i("hslu_mobApp", "Fragment onStop() aufgerufen")
	}

	override fun onDetach() {
		super.onDetach()
		Log.i("hslu_mobApp", "Fragment onDetach() aufgerufen")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.i("hslu_mobApp", "Fragment onDestroy() aufgerufen")
	}

	override fun onDestroyView() {
		super.onDestroyView()
		Log.i("hslu_mobApp", "Fragment onDestroyView() aufgerufen")
	}
}
