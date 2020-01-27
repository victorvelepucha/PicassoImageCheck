package com.vicsoft.picassoimagecheck

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_load_external_image.*


class LoadExternalImageActivity : AppCompatActivity() {

    private val RESULT_LOAD_IMAGE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_external_image)
        buttonChooseAnExternalImage.setOnClickListener{
            val i = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

            startActivityForResult(i, RESULT_LOAD_IMAGE)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {
            val selectedImage: Uri? = data.data
            Picasso.get().load(selectedImage).fit().placeholder(com.vicsoft.picassoimagecheck.R.drawable.spinner)
                .into(imageViewFromExternalDevice, object : Callback {
                    override fun onSuccess() {
                        val text: String = getString(R.string.textViewCodeUri, selectedImage.toString())
                        val styledText: Spanned = Html.fromHtml(text, FROM_HTML_MODE_LEGACY)
                        textViewPathExternalImagen.text = styledText

                        textViewCodeSourceToCallExternalStorage.setText (R.string.textStorageSource)
                    }

                    override fun onError(e: Exception) {
                        Toast.makeText(applicationContext, com.vicsoft.picassoimagecheck.R.string.errorToLoadImage, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    /*private fun checkForPermission() {
        val permissionCheck = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        }
    }

    private fun hasPermission(permissionToCheck: String): Boolean {
        val permissionCheck = ContextCompat.checkSelfPermission(this, permissionToCheck)
        return permissionCheck == PackageManager.PERMISSION_GRANTED
    }*/
}
