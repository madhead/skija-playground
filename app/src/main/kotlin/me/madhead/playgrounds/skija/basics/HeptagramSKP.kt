package me.madhead.playgrounds.skija.basics

import me.madhead.playgrounds.skija.dump
import org.jetbrains.skija.PictureRecorder
import org.jetbrains.skija.Rect

/**
 * Draws a [heptagram] into an `.SKP` file and prints its path.
 * SKP files could be useful to debug the drawing pipeline using the [Skia Debugger][https://debugger.skia.org].
 */
fun main() {
    val recorder = PictureRecorder()

    heptagram(recorder.beginRecording(Rect.makeWH(Heptagram.size.toFloat(), Heptagram.size.toFloat())))
    recorder.dump()
}
