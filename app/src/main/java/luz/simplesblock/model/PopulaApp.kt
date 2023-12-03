package luz.simplesblock.model

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log


class PopulaApp(private val context: Context) {
    fun popula(): List<App> {
        Log.d("teste", "okaaa")
        val listaApp: MutableList<App> = mutableListOf()
        val packageManager: PackageManager = context.packageManager
        val apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        for (app in apps) {
            if ((app.flags and ApplicationInfo.FLAG_SYSTEM) == 0) {
                // Este aplicativo é do sistema
                // Lide com o aplicativo do sistema
                val appIcon = app.loadIcon(packageManager)
                Log.d("infod", app.packageName)
                listaApp.add(App(app.loadLabel(packageManager).toString(), false, appIcon))
            }
        }
        return listaApp.sortedBy { it.text }
    }
}