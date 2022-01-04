package com.ashish.volleydemo


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    var currentImageUrl: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadmeme()
    }

    private fun loadmeme() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"


        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,

            { response ->
                val currentImageUrl = response.getString("url")

                Glide.with(this).load(currentImageUrl).into(findViewById(R.id.image))
            },
            {

            })

        queue.add(jsonObjectRequest)
    }


    fun next(view: View) {
        loadmeme()
    }
}
