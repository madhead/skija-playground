package me.madhead.playgrounds.skija.heptagram

import org.jetbrains.skija.PictureRecorder
import org.jetbrains.skija.Rect
import java.nio.file.Files

/**
 * Draws a [heptagram] into a `.SKP` file and prints its path.
 * SKP files could be useful to debug the drawing pipeline using the [Skia Debugger][https://debugger.skia.org].
 */
fun main() {
    val recorder = PictureRecorder()

    heptagram(recorder.beginRecording(Rect.makeWH(256F, 256F)))

    recorder
            .finishRecordingAsPicture()
            .serializeToData()
            ?.bytes
            ?.let { bytes ->
                val file = Files.createTempFile("", ".skp")

                file.toFile().writeBytes(bytes)
                println(file.toString())
            }
}
