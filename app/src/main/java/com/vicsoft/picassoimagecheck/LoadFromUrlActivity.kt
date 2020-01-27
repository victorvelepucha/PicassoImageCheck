package com.vicsoft.picassoimagecheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_load_from_url.*

class LoadFromUrlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_from_url)
        //editTextUrlImage.setText(R.string.exampleToUseUrl)
        editTextUriImage.setText( R.string.exampleToUseUrl)
        textViewCodeSourceUrl.setText( getString(R.string.textUrlDirection, editTextUriImage.text))

        buttonLoadFromUrl.setOnClickListener {
            Picasso.get().load(editTextUriImage.text.toString()).fit().placeholder(R.drawable.spinner)
                .into(imageViewImageLoadedFromUrl, object : Callback {
                    override fun onSuccess() {
                        textViewCodeSourceUrl.setText( getString(R.string.textUrlDirection, editTextUriImage.text))
                    }

                    override fun onError(e: Exception) {
                        Toast.makeText(applicationContext, R.string.errorToLoadImage, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
}
