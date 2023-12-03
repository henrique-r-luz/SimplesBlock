package luz.simplesblock

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import luz.simplesblock.model.PopulaApp
import luz.simplesblock.service.AppBlockService

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun startBlockingService() {
        val serviceIntent = Intent(this, AppBlockService::class.java)
        startForegroundService(serviceIntent)
    }
}