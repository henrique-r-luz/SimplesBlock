package luz.simplesblock.listAdapter

import android.app.ActivityManager
import android.app.usage.UsageStatsManager
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import luz.simplesblock.R
import luz.simplesblock.model.App
import java.util.Calendar

class AppAdapter(
    private val dataset: List<App>
): RecyclerView.Adapter<AppAdapter.ItemViewHolder>()  {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view),
        CompoundButton.OnCheckedChangeListener {
        val textView: TextView = view.findViewById(R.id.app_nome)
        val switch: Switch = view.findViewById(R.id.is_block)
        var icone:ImageView  = view.findViewById(R.id.icone)

        init {
            switch.setOnCheckedChangeListener(this)
        }

        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            // Log.d("msg","teste")
            val context = itemView.context
          /*  val activityManager =
                context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val runningAppProcesses = activityManager.getRunningAppProcesses()

            for (processInfo in runningAppProcesses) {

                Log.d("services_novo", processInfo.processName)
            }*/
           /* val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val runningTasks = activityManager.getRunningTasks(Int.MAX_VALUE)

            // Verifique se o pacote do aplicativo de terceiros está presente entre as tarefas em execução
            for (taskInfo in runningTasks) {
                Log.d("services_novo", "1 "+taskInfo.topActivity?.packageName.toString())
                Log.d("services_novo", "2 "+ taskInfo.baseActivity?.packageName)
               /* if (taskInfo.topActivity?.packageName == packageName || taskInfo.baseActivity?.packageName == packageName) {
                    return true
                }*/
            }*/
            val usageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val endTime = System.currentTimeMillis()
            val startTime = endTime - (1000 * 60) // Intervalo de 1 minuto

            val usageStats = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime)

            if (usageStats != null) {


                // Itera sobre os aplicativos com estatísticas de uso
                //usageStats.sortedByDescending { it.lastTimeUsed }.firstOrNull()
                for (stats in usageStats) {

                    if(stats.lastTimeUsed>= startTime && stats.lastTimeUsed <= endTime){
                 //   val lastTimeUsed = stats.lastTimeUsed
                 //   if (lastTimeUsed >= calendar.timeInMillis) {
                        val packageName = stats.packageName
                        Log.d("ActiveApps", "App em execução: $packageName")
                    }
                }
            }

        }

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