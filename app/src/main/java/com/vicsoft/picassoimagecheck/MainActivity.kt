package com.vicsoft.picassoimagecheck

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonLoadFromUrl.setOnClickListener {
            val intentFromUrl = Intent(this,LoadFromUrlActivity::class.java)
            startActivity(intentFromUrl)
        }
        buttonLoadFromAppResources.setOnClickListener {
            val intentFromResource = Intent(this,LoadFromResourceActivity::class.java)
            startActivity(intentFromResource)
        }
        buttonLoadFromStorage.setOnClickListener{
            val intentFromStorage = Intent(this,LoadExternalImageActivity::class.java)
            startActivity(intentFromStorage)
        }
    }
}
