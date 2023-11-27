package luz.simplesblock.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import luz.simplesblock.R
import luz.simplesblock.databinding.FragmentListaAppBinding
import luz.simplesblock.listAdapter.AppAdapter
import luz.simplesblock.model.App
import luz.simplesblock.model.PopulaApp



/**
 * A simple [Fragment] subclass.
 * Use the [ListaApp.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaApp : Fragment() {

    private var _binding: FragmentListaAppBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val dataSet:List<App> = PopulaApp().popula()

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
        recyclerView.adapter = AppAdapter(view.context, dataSet)

    }


}