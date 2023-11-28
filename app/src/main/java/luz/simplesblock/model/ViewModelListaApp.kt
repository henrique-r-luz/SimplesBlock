package luz.simplesblock.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData




class ViewModelListaApp(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    private val _appMutableLiveData = MutableLiveData<List<App>>()
    val appMutableLiveData: LiveData<List<App>> get() = _appMutableLiveData
    init{
       // val context = getApplication<Application>().applicationContext
        _appMutableLiveData.value  = PopulaApp(context).popula()
    }
}