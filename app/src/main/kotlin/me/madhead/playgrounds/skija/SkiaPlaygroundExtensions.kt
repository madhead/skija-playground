package me.madhead.playgrounds.skija

import org.jetbrains.skija.EncodedImageFormat
import org.jetbrains.skija.Picture
import org.jetbrains.skija.PictureRecorder
import org.jetbrains.skija.Surface
import java.nio.file.Files
import java.nio.file.Path

fun Picture.dump() {
    this
            .serializeToData()
            ?.bytes
            ?.let { bytes ->
                val file = Files.createTempFile("", ".skp")

                file.toFile().writeBytes(bytes)
                println(file.toString())
            }
}

fun PictureRecorder.dump() {
    this
            .finishRecordingAsPicture()
            .dump()
}

fun Surface.dumpAsJPG(): Path = this
        .makeImageSnapshot()
        ?.encodeToData(EncodedImageFormat.JPEG)
        ?.bytes
        ?.let { bytes ->
            val file = Files.createTempFile("", ".jpg")

            file.toFile().writeBytes(bytes)

            file
        }!!

fun Surface.dumpAsPNG(): Path = this
        .makeImageSnapshot()
        ?.encodeToData(EncodedImageFormat.PNG)
        ?.bytes
        ?.let { bytes ->
            val file = Files.createTempFile("", ".png")

            file.toFile().writeBytes(bytes)

            file
        }!!

fun Path.open(): Process = ProcessBuilder("xdg-open", this.toAbsolutePath().toString()).start()
