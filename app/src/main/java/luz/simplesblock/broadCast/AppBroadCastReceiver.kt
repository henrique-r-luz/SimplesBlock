package luz.simplesblock.broadCast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AppBroadCastReceiver:  BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("broad","olaaa");
        if (context != null && intent != null) {
            Toast.makeText(context, "Inicialização impedida", Toast.LENGTH_SHORT).show()
            // Verifique sua condição específica aqui antes de permitir a inicialização
            /*if (suaCondicaoEspecifica()) {
                // Se a condição for atendida, inicie a atividade desejada
                val launchIntent = context.packageManager.getLaunchIntentForPackage(context.packageName)
                context.startActivity(launchIntent)
            } else {
                // Se a condição não for atendida, exiba uma mensagem ou realize outra ação
                Toast.makeText(context, "Inicialização impedida", Toast.LENGTH_SHORT).show()
            }*/
        }
    }

}