package luz.simplesblock.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelListaAppFactory(private val application: Application):ViewModelProvider.Factory  {
    override  fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelListaApp::class.java)) {
            return ViewModelListaApp(application) as T
        }
        throw IllegalArgumentException("Classe de ViewModel desconhecida")
    }
}