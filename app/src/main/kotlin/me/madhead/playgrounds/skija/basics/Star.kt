package me.madhead.playgrounds.skija.basics

import me.madhead.playgrounds.skija.dumpAsJPG
import me.madhead.playgrounds.skija.open
import org.jetbrains.skija.Canvas
import org.jetbrains.skija.EncodedImageFormat
import org.jetbrains.skija.Paint
import org.jetbrains.skija.PaintMode
import org.jetbrains.skija.Path
import org.jetbrains.skija.Surface
import java.nio.file.Files
import kotlin.math.cos
import kotlin.math.sin

/**
 * Draws a star into a `.JPEG` file and opens the result.
 */
fun main() {
    val surface = Surface.makeRasterN32Premul(256, 256)
    val canvas = surface.canvas

    val path = Path()

    path.moveTo(76.104085F, 208.01411F) // <4>
    path.lineTo(128F, 48.294907F) // <5>
    path.lineTo(179.89591F, 208.01411F)
    path.lineTo(44.030648F, 109.30221F)
    path.lineTo(211.96935F, 109.30221F)
    path.closePath() // <6>

    val paint = Paint().apply {
        isAntiAlias = true
        mode = PaintMode.STROKE
        color = 0xFFFFD700.toInt()
    }

    canvas.clear(0xFF000000.toInt())
    canvas.drawPath(path, paint)
    surface.dumpAsJPG().open()
}
