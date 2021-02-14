package me.madhead.playgrounds.skija.text

import me.madhead.playgrounds.skija.Fonts
import me.madhead.playgrounds.skija.dump
import me.madhead.playgrounds.skija.dumpAsJPG
import me.madhead.playgrounds.skija.open
import org.jetbrains.skija.Canvas
import org.jetbrains.skija.Paint
import org.jetbrains.skija.PictureRecorder
import org.jetbrains.skija.Rect
import org.jetbrains.skija.Surface
import org.jetbrains.skija.TextLine

object SimpleText {
    const val width = 1024
    const val height = 768
}

/**
 * Draws a single text line in the middle of the drawing.
 */
fun main() {
    val recorder = PictureRecorder()

    deathburger(recorder.beginRecording(Rect.makeWH(SimpleText.width.toFloat(), SimpleText.height.toFloat())))

    val picture = recorder.finishRecordingAsPicture()
    val surface = Surface.makeRasterN32Premul(SimpleText.width, SimpleText.height)

    picture.playback(surface.canvas)
    picture.dump()
    surface.dumpAsJPG()?.open()
}

/**
 * All the credits go to Josan Gonzalez. Check out his work!
 * - https://www.instagram.com/deathburger
 * - https://deathherald.tumblr.com
 * - https://citadel9.com
 * - https://www.kickstarter.com/profile/deathburger/created
 */
internal fun deathburger(canvas: Canvas) {
    val line = TextLine.make("THE FUTURE", Fonts.ALDO_THE_APACHE_112)
    val paint = Paint().apply {
        color = 0xFFC1E6A1.toInt()
    }

    canvas.clear(0xFFC53563.toInt())
    canvas.drawTextLine(
            line,
            (SimpleText.width - line.width) / 2,
            (SimpleText.height + line.height) / 2, // Y axis goes from top to bottom, and the text is drawn from the bottom left corner, thus "+" here
            paint
    )
}
