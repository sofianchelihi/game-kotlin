package com.example.tp2_exo2

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader


class Phrases2(var FileName : String,context: Context){
    var phrases :MutableList<Phrase2> = mutableListOf<Phrase2>()
    init{
        readFile(FileName,context)
    }


    fun readFile(fileName: String,context: Context){
        val inputStream = context.assets.open(fileName)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        var line: String? = bufferedReader.readLine()
        while (line != null) {
            var tmp = line.split('/')
            var phrase : Phrase2 = Phrase2(tmp[0],tmp[1])
            phrases.add(phrase)
            line = bufferedReader.readLine()
        }
        bufferedReader.close()
    }
}