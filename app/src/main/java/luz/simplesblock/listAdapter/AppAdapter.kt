package luz.simplesblock.listAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import luz.simplesblock.R
import luz.simplesblock.model.App

class AppAdapter(
    private val context: Context,
    private val dataset: List<App>
): RecyclerView.Adapter<AppAdapter.ItemViewHolder>()  {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.app_nome)
        val switch: Switch = view.findViewById(R.id.is_block)
        var icone:ImageView  = view.findViewById(R.id.icone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_app, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.text
        holder.switch.setChecked(item.isBlock)
        holder.icone.setImageDrawable(item.imageResource)
    }
}