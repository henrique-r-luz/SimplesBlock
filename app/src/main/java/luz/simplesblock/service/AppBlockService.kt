package luz.simplesblock.service

import android.app.ActivityManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.coroutines.delay
import luz.simplesblock.MainActivity

class AppBlockService : Service() {

    private val NOTIFICATION_ID = 1
    private val CHANNEL_ID = "AppBlockingChannel"
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

        // Inicia o serviço em primeiro plano com uma notificação válida
        val notification = createHiddenNotification()
        startForeground(NOTIFICATION_ID, notification)
        Log.d("Criaservices", "Cria")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Executar o código de bloqueio aqui
        Log.d("services", "aquiiii")
        blockApp("com.example.android.dessertclicker", startId)

        return START_STICKY
    }

    private fun blockApp(packageName: String, startId: Int) {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        Job(startId, activityManager).start()

    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "AppBlocking Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /*private fun createNotification(): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("AppBlocking está em execução")
            .setContentText("Toque para abrir o aplicativo")
            //.setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)

        return builder.build()
    }*/

    private fun createHiddenNotification(): Notification {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            //.setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("AppBlocking está em execução")
            .setContentText("Toque para abrir o aplicativo")
            .setPriority(NotificationCompat.PRIORITY_MIN) // Prioridade mínima para não exibir na barra de notificações

        return builder.build()
    }



    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}


class Job(
    private val startId: Int,
    private val activityManager: ActivityManager
) : Thread() {
    override fun run() {
        while (true) {
            sleep(1000)
            val runningAppProcesses = activityManager.runningAppProcesses
            for (processInfo in runningAppProcesses) {
                Log.d("services", processInfo.processName)
                /* if (processInfo.processName == packageName) {
                 try {
                     // Tenta encerrar o processo do aplicativo alvo
                     //android.os.Process.killProcess(processInfo.pid)
                     // Opcionalmente, você pode mostrar uma mensagem ao usuário ou realizar outra ação
                   //  showToast("Aplicativo bloqueado: $packageName")
                 } catch (e: Exception) {
                     e.printStackTrace()
                 }
             }*/
            }
        }
    }

}
