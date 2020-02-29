package ch.hslu.mobpro.firstappfinal.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MessageViewModel(application: Application) : AndroidViewModel(application) {

	private val msg: MutableLiveData<String> = MutableLiveData()

	fun updateMessage(message: String) {
		msg.value = message
	}

	fun getMsg(): LiveData<String> {
		return msg
	}

	fun getMsgAsString(): String {
		return msg.value.toString()
	}

}