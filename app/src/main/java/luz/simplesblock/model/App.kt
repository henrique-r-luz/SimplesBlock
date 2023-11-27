package luz.simplesblock.model

import androidx.annotation.DrawableRes

data class App(
    var text: String,
    var isBlock:Boolean,
    @DrawableRes var imageResourceId: Int
)