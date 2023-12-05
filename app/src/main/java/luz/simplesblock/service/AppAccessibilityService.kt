package luz.simplesblock.service

import android.accessibilityservice.AccessibilityService
import android.app.KeyguardManager
import android.content.Context
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import androidx.annotation.RequiresApi

class AppAccessibilityService: AccessibilityService() {

    private var authenticationDialogShown = false
    private val handler = Handler(Looper.getMainLooper())
    override fun onAccessibilityEvent(event: AccessibilityEvent) {
       // Log.d("AccessibilityService","entrou no evento")
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val packageName = event.packageName?.toString() ?: ""
            val className = event.className?.toString() ?: ""
            Log.d("AccessibilityService", "Opened app: $packageName, Activity: $className")

            // Aqui você pode adicionar lógica para impedir a abertura de aplicativos específicos
            // Isso não é recomendado para bloquear aplicativos, é apenas um exemplo educacional
        }
    }




    override fun onInterrupt() {
        // Implementação necessária, mas não usada neste exemplo
    }
}