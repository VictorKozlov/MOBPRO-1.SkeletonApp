package ch.hslu.mobpro.firstappfinal.overview

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ch.hslu.mobpro.firstappfinal.MainActivity
import ch.hslu.mobpro.firstappfinal.QuestionFragment
import ch.hslu.mobpro.firstappfinal.R
import ch.hslu.mobpro.firstappfinal.lifecyclelog.LifecycleLogActivity
import java.net.URL

class OverviewFragment constructor() : Fragment(R.layout.fragment_overview) {

	private var questionFragment = QuestionFragment.newInstance("Wie laufts?")

	//TODO init messageViewModel
	var messageViewModel: MessageViewModel = MessageViewModel(Application())

	companion object {
		fun newInstance(): OverviewFragment {
			return OverviewFragment();
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		//TODO : observe text from MessageViewModel and set text
		this.observeAnswer()

		view.findViewById<Button>(R.id.main_button_logActivity).setOnClickListener { startLogActivity() }
		view.findViewById<Button>(R.id.main_button_startBrowser).setOnClickListener { startBrowser() }
		view.findViewById<Button>(R.id.main_button_questionActivity).setOnClickListener { startQuestionFragment() }
	}

	private fun observeAnswer() {
		messageViewModel?.updateMessage(questionFragment.messageViewModel.getMsgAsString())

		if(messageViewModel?.getMsgAsString() != "null"){
			view?.findViewById<TextView>(R.id.main_textView_result)?.setText(messageViewModel.getMsgAsString())
		}
		else{
			view?.findViewById<TextView>(R.id.main_textView_result)?.setText("")
		}
	}

	private fun startLogActivity() {
		var parentActivity = getActivity()
		var intent = Intent (parentActivity, LifecycleLogActivity::class.java)
		parentActivity?.startActivity(intent)
	}

	private fun startBrowser() {
		var openUrlIntent = Intent(android.content.Intent.ACTION_VIEW)
		openUrlIntent.data = Uri.parse("http://www.hslu.ch")
		startActivity(openUrlIntent)
	}

	private fun startQuestionFragment() {

		parentFragmentManager.beginTransaction().replace(
				R.id.fragment_host,
				questionFragment)
				.addToBackStack("question")
				.commit()
	}
}