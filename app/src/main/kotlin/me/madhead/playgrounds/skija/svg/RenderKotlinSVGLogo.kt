package me.madhead.playgrounds.skija.svg

import me.madhead.playgrounds.skija.dumpAsPNG
import me.madhead.playgrounds.skija.open
import org.jetbrains.skija.Canvas
import org.jetbrains.skija.Data
import org.jetbrains.skija.Surface
import org.jetbrains.skija.svg.DOM

object KotlinSVGLogo {
    const val width = 256
    const val height = 256
}

/**
 * Renders [official Kotlin logo][https://kotlinlang.org/docs/faq.html#where-can-i-get-an-hd-kotlin-logo] to a `.PNG`.
 */
fun main() {
    val surface = Surface.makeRasterN32Premul(KotlinSVGLogo.width, KotlinSVGLogo.height)

    kotlinSVGLogo(surface.canvas)
    surface.dumpAsPNG()?.open()
}

/**
 * Renders [official Kotlin SVG logo][https://kotlinlang.org/docs/faq.html#where-can-i-get-an-hd-kotlin-logo].
 */
internal fun kotlinSVGLogo(canvas: Canvas) {
    val svg = Data.makeFromBytes(
            (object {}).javaClass.classLoader.getResource("kotlin.logo.svg")?.readBytes()
    )
    val dom = DOM(svg)

    // Official Kotlin SVG logo doesn't set any width and height, only viewbox. So, ontainerSize must be specified.
    dom.setContainerSize(KotlinSVGLogo.width.toFloat(), KotlinSVGLogo.height.toFloat())
    dom.render(canvas)
}
