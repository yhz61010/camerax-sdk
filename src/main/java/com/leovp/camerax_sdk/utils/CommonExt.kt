@file:Suppress("unused")

package com.leovp.camerax_sdk.utils

import android.util.Size
import android.view.Surface
import com.leovp.lib_common_kotlin.exts.round
import java.nio.ByteBuffer

/**
 * Author: Michael Leo
 * Date: 2022/5/31 10:19
 */

/**
 * Helper extension function used to extract a byte array from an image plane buffer
 */
internal fun ByteBuffer.toByteArray(): ByteArray {
    rewind()    // Rewind the buffer to zero
    val data = ByteArray(remaining())
    get(data)   // Copy the buffer into a byte array
    return data // Return the byte array
}

internal val SURFACE_ORIENTATIONS_TO_DEGREE = mapOf(Surface.ROTATION_0 to 0,
    Surface.ROTATION_90 to 90,
    Surface.ROTATION_180 to 180,
    Surface.ROTATION_270 to 270)

internal val DEGREE_TO_SURFACE_ORIENTATIONS = mapOf(0 to Surface.ROTATION_0,
    90 to Surface.ROTATION_90,
    180 to Surface.ROTATION_180,
    270 to Surface.ROTATION_270)

internal fun getCameraSizeTotalPixels(size: Size): String {
    val total = size.width * size.height
    val calTotal = total * 1f / 1_000_000
    return if (calTotal > 10) {
        "${calTotal.toInt()}MP"
    } else {
        "${calTotal.round(1)}MP"
    }
}