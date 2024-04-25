package luz.simplesblock.service

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log

class AppBlockService2: Service() {

    private var handler: Handler = Handler(Looper.getMainLooper())
    private var monitorTask: Runnable = object : Runnable {
        override fun run() {
            checkIfAppOpened()
            handler.postDelayed(this, 1000) // Verifica a cada segundo
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startMonitoring()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        stopMonitoring()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun startMonitoring() {
        handler.post(monitorTask)
    }

    private fun stopMonitoring() {
        handler.removeCallbacks(monitorTask)
    }

    private fun checkIfAppOpened() {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningAppProcesses = activityManager.runningAppProcesses
        val targetPackageName = "com.example.targetapp" // Pacote do aplicativo desejado

        for (processInfo in runningAppProcesses) {
            Log.d("services", processInfo.processName)
        }
    }
}
