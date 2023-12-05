package luz.simplesblock

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi
import luz.simplesblock.model.PopulaApp
import luz.simplesblock.service.AppBlockService

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startAcessibikit()

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun startBlockingService() {
        val serviceIntent = Intent(this, AppBlockService::class.java)
        startForegroundService(serviceIntent)
    }

    private fun startAcessibikit(){
        startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
    }
}