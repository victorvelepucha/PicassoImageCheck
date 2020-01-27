package com.vicsoft.picassoimagecheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_load_from_resource.*

class LoadFromResourceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_from_resource)

        Picasso.get().load(R.drawable.logo).fit().placeholder(R.drawable.spinner)
            .into(imageViewFromResourceLoaded, object : Callback {
                override fun onSuccess() {
                    textViewCodeSourceResource.setText(R.string.textUrlResource)
                }

                override fun onError(e: Exception) {
                    Toast.makeText(applicationContext, R.string.errorToLoadImage, Toast.LENGTH_SHORT).show()
                }
            })
    }
}
