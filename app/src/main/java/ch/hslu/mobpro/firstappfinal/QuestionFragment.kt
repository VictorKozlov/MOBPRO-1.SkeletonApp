package ch.hslu.mobpro.firstappfinal

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.hslu.mobpro.firstappfinal.overview.MessageViewModel


class QuestionFragment : Fragment(R.layout.fragment_questions) {

	//TODO: init messageViewModel
	var messageViewModel: MessageViewModel = MessageViewModel(Application())

	companion object {
		const val ARGS_QUESTIONS = "question";

		fun newInstance(question: String): QuestionFragment {
			val fragment = QuestionFragment()
			val args = Bundle()
			args.putString(ARGS_QUESTIONS, question)

			fragment.arguments = args
			return fragment
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		// Read parameter and show on view.
		val question = arguments?.getString(ARGS_QUESTIONS);
		question?.let { view.findViewById<TextView>(R.id.question_label).text = it }

		view.findViewById<View>(R.id.question_button_done).setOnClickListener { buttonClicked() }
	}

	private fun buttonClicked() {
		//TODO: set answer in viewmodel

		messageViewModel.updateMessage(answerText)
		parentFragmentManager.popBackStack()
	}

	private val answerText: String
		get() {
			val editText = view?.findViewById<View>(R.id.question_text_answer) as EditText
			return editText.text.toString()
		}
}