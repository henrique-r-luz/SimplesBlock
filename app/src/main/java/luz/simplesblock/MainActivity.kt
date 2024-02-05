package luz.simplesblock

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
import androidx.annotation.RequiresApi
import luz.simplesblock.service.AppBlockService

class MainActivity : AppCompatActivity() {
    private val sharedPreferencesKey = "showServiceSettings"
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Verificar se a tela ServiceSettingsActivity já foi mostrada
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val showServiceSettings = sharedPreferences.getBoolean(sharedPreferencesKey, true)

        if (showServiceSettings) {

            // Se ainda não foi mostrada, abrir a tela e salvar o estado
            startActivity(Intent(ACTION_ACCESSIBILITY_SETTINGS))
            //val intent = Intent(this, ServiceSettingsActivity::class.java)
            //startActivity(intent)

            // Salvar o estado para que a tela não seja mostrada novamente
            val editor = sharedPreferences.edit()
            editor.putBoolean(sharedPreferencesKey, false)
            editor.apply()
        }

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun startBlockingService() {
        val serviceIntent = Intent(this, AppBlockService::class.java)
        startForegroundService(serviceIntent)
    }

}