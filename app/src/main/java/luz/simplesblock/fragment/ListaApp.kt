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
    //private lateinit var dataSet:List<App>
    private lateinit var viewModel: ViewModelListaApp



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentListaAppBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        viewModel = ViewModelProvider(this, ViewModelListaAppFactory(requireActivity().application))
            .get(ViewModelListaApp::class.java)
       /* viewModel.appMutableLiveData.observe(this,Observer<List<App>?>(
            dataSet-> recyclerView.adapter = AppAdapter(view.context, dataSet)
        ))*/

       /* viewModel.appMutableLiveData.observe(viewLifecycleOwner, Observer { dataSet: ->
            recyclerView.adapter = AppAdapter(view.context, dataSet)
        })*/

        viewModel.appMutableLiveData.observe(viewLifecycleOwner, Observer { dataSet ->
            recyclerView.adapter = AppAdapter(dataSet)
        })


        /*dataSet = PopulaApp(view.context).popula()
        recyclerView = binding.recyclerView
        recyclerView.adapter = AppAdapter(view.context, dataSet)*/

    }



}

