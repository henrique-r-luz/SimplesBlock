package luz.simplesblock.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import luz.simplesblock.databinding.FragmentListaAppBinding
import luz.simplesblock.listAdapter.AppAdapter
import luz.simplesblock.model.App
import luz.simplesblock.model.PopulaApp
import luz.simplesblock.model.ViewModelListaApp
import luz.simplesblock.model.ViewModelListaAppFactory


/**
 * A simple [Fragment] subclass.
 * Use the [ListaApp.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaApp : Fragment() {

    private var _binding: FragmentListaAppBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModelListaApp: ViewModelListaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaAppBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        viewModelListaApp = ViewModelProvider(this, ViewModelListaAppFactory(requireActivity().application))
            .get(ViewModelListaApp::class.java)
        viewModelListaApp.appMutableLiveData.observe(viewLifecycleOwner, Observer { dataSet ->
            recyclerView.adapter = AppAdapter(dataSet)
        })
    }
}

