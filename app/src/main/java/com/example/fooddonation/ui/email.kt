package com.example.fooddonation.ui


import android.util.Base64
import com.android.volley.toolbox.HttpResponse
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.CloseableHttpResponse
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.StringEntity
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient
//import org.apache.http.HttpResponse
//import org.apache.http.client.methods.HttpPost
//import org.apache.http.impl.client.DefaultHttpClient
//import org.apache.http.entity.StringEntity
import org.json.JSONArray
import org.json.JSONObject

fun sendEmailUsingMailjet() {

val apiKey = "a110eb32b72d9fa6a5cc4056e53ed637"
val apiSecret = "44b1408b3ae1f4553b0d67c4815abbad"
    val mailjetApiUrl = "https://api.mailjet.com/v3.1/send"

    val httpClient = DefaultHttpClient()
    val httpPost = HttpPost(mailjetApiUrl)
    httpPost.addHeader("Content-Type", "application/json")
    httpPost.addHeader("Authorization", "Basic " + Base64.encodeToString("$apiKey:$apiSecret".toByteArray(), Base64.NO_WRAP))

    val payload = JSONObject().apply {
        put("From", JSONObject(mapOf("Email" to "sender@example.com", "Name" to "Sender Name")))
        put("To", JSONArray().put(JSONObject(mapOf("Email" to "recipient@example.com", "Name" to "Recipient Name"))))
        put("Subject", "Your Subject")
        put("TextPart", "Hello, this is the email content.")
    }

    val entity = StringEntity(payload.toString())
    httpPost.entity = entity

    val response: CloseableHttpResponse? = httpClient.execute(httpPost)
    // Handle the response as needed
}
