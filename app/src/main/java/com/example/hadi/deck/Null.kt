package com.example.hadi.deck

import java.io.OutputStream

open class Null (){
    open fun print(outputStream: OutputStream) = outputStream.write("Null".toByteArray())
}