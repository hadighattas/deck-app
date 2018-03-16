package com.example.hadi.deck

import java.io.OutputStream

/**
 * Null Class that has a print method
 */
open class Null {
    open fun print(outputStream: OutputStream) = outputStream.write("Null\r\n".toByteArray())
}