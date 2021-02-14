package me.madhead.playgrounds.skija.heptagram

import org.jetbrains.skija.Canvas
import org.jetbrains.skija.EncodedImageFormat
import org.jetbrains.skija.Paint
import org.jetbrains.skija.Surface
import java.nio.file.Files
import kotlin.math.cos
import kotlin.math.sin

/**
 * Draws a [heptagram] into a `.JPEG` file and opens the result.
 */
fun main() {
    val surface = Surface.makeRasterN32Premul(256, 256)

    heptagram(surface.canvas)

    surface
            .makeImageSnapshot()
            .encodeToData(EncodedImageFormat.JPEG)
            ?.bytes
            ?.let { bytes ->
                val file = Files.createTempFile("", ".jpg")

                file.toFile().writeBytes(bytes)

                ProcessBuilder("xdg-open", file.toAbsolutePath().toString()).start()
            }
}

/**
 * Draws a 7⁄3 [heptagram][https://en.wikipedia.org/wiki/Heptagram].
 * Original C++ code from Skia documentation: https://fiddle.skia.org/c/@skcanvas_star.
 */
internal fun heptagram(canvas: Canvas) {
    val scale = 256F
    val r = 0.45F * scale
    val tau = 6.2831853F

    val path = org.jetbrains.skija.Path()

    path.moveTo(r, 0.0f);
    for (i in 1..6) {
        val theta = 3 * i * tau / 7

        path.lineTo(r * cos(theta), r * sin(theta))
    }
    path.closePath()

    val paint = Paint()

    paint.isAntiAlias = true
    canvas.clear(0xFFFFFFFF.toInt())
    canvas.translate(0.5f * scale, 0.5f * scale)
    canvas.drawPath(path, paint)
}
