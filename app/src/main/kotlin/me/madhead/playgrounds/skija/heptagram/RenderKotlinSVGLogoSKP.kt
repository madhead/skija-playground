package me.madhead.playgrounds.skija.heptagram

import org.jetbrains.skija.PictureRecorder
import org.jetbrains.skija.Rect

/**
 * Renders [official Kotlin logo][https://kotlinlang.org/docs/faq.html#where-can-i-get-an-hd-kotlin-logo] to an `.SKP.
 * Check it out in the [Skia Debugger][https://debugger.skia.org]!
 */
fun main() {
    val recorder = PictureRecorder()

    kotlinSVGLogo(recorder.beginRecording(Rect.makeWH(KotlinSVGLogo.width.toFloat(), KotlinSVGLogo.height.toFloat())))
    recorder.dump()
}
