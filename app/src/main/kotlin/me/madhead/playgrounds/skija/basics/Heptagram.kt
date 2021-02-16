package me.madhead.playgrounds.skija.basics

import me.madhead.playgrounds.skija.dumpAsJPG
import me.madhead.playgrounds.skija.open
import org.jetbrains.skija.Canvas
import org.jetbrains.skija.Paint
import org.jetbrains.skija.Surface
import kotlin.math.cos
import kotlin.math.sin

object Heptagram {
    const val size = 256
}

/**
 * Draws a [heptagram] into a `.JPEG` file and opens the result.
 */
fun main() {
    val surface = Surface.makeRasterN32Premul(Heptagram.size, Heptagram.size)

    heptagram(surface.canvas)
    surface.dumpAsJPG().open()
}

/**
 * Draws a 7⁄3 [heptagram][https://en.wikipedia.org/wiki/Heptagram].
 * Original C++ code from Skia documentation: https://fiddle.skia.org/c/@skcanvas_star.
 */
internal fun heptagram(canvas: Canvas) {
    val r = 0.45F * Heptagram.size
    val tau = 6.2831853F
    val path = org.jetbrains.skija.Path()

    path.moveTo(r, 0.0f);
    for (i in 1..6) {
        val theta = 3 * i * tau / 7

        path.lineTo(r * cos(theta), r * sin(theta))
    }
    path.closePath() // Make sure to call closePath(), and not close()!

    val paint = Paint()

    paint.isAntiAlias = true
    canvas.clear(0xFFFFFFFF.toInt())
    canvas.translate(0.5f * Heptagram.size, 0.5f * Heptagram.size)
    canvas.drawPath(path, paint)
}
