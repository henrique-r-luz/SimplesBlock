package luz.simplesblock.model

import android.util.Log
import com.github.javafaker.Faker


class PopulaApp {
    fun popula():List<App>{
        Log.d("Test","popula")
        val listaApp: MutableList<App> = mutableListOf()
        for(i in 1..50){
            val faker = Faker()
            // Gerar uma palavra fictícia
            val fakePalavra = faker.lorem().word()
            listaApp.add(App(fakePalavra,false,0))
        }
        return listaApp
    }
}