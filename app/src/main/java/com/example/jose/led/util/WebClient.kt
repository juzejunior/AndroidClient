package com.example.jose.led.util

import android.util.Log
import com.squareup.okhttp.*
import java.io.IOException
import com.squareup.okhttp.RequestBody

/**
 *
 * Created by jose on 28/10/17.
 */
class WebClient {

    @Throws(IOException::class)
    fun doPostRequest(cmd:String): String? {
        var answer:String? = ""
        val client = OkHttpClient()
        val url = "http://192.168.1.177:3003"
        Log.d("COMMAND", "Making request: "+cmd)
        val mediaType: MediaType = MediaType.parse("application/json; charset=utf-8")
        val body = RequestBody.create(mediaType, cmd)
        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()

        client.newCall(request)
                .enqueue(object: Callback {

                    override fun onFailure(request: Request?, e: IOException?) {
                    }

                    override fun onResponse(response: Response?) {
                       val res = response?.body()?.string()
                       answer = res
                       Log.d("AA", "resp["+answer+"]")
                    }

                });

        return answer
    }
}
