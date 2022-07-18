package com.dani.apimarvel.model

import com.dani.apimarvel.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {

    companion object{
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = BuildConfig.PUBLIC_API_KEY
        const val PRIVATE_KEY = BuildConfig.PRIVATE_API_KEY
        const val LIMIT = 3
        fun hash():String{
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}