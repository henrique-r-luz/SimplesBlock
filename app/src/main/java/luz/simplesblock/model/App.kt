package luz.simplesblock.model

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

data class App(
    var text: String,
    var isBlock:Boolean,
    var imageResource: Drawable
)