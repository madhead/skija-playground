package me.madhead.playgrounds.skija

import org.jetbrains.skija.Font

/**
 * Skija's [Fonts][Font] are expensive to create, so they should be cached in a real app, unless you need dynamic font sizes.
 */
object Fonts {
    val ALDO_THE_APACHE_112 = Font(Typefaces.ALDO_THE_APACHE, 112F)
}
