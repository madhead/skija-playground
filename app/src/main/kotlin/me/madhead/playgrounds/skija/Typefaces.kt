package me.madhead.playgrounds.skija

import org.jetbrains.skija.Data
import org.jetbrains.skija.Typeface

/**
 * Skija's [Typefaces][Typeface] are expensive to create, so they should be cached in a real app.
 */
object Typefaces {
    val ALDO_THE_APACHE = Typeface.makeFromData(
            Data.makeFromBytes(
                    (object {}).javaClass.classLoader.getResource("AldoTheApache.ttf")?.readBytes()
            )
    )
}
