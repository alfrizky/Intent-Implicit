package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnMoveActivity = findViewById<Button>(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener {
         onClick()
        }
        val btnDialNumber = findViewById<Button>(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener {
            onDial()
        }
        val btnOpenCamera = findViewById<Button>(R.id.btn_open_camera)
        btnOpenCamera.setOnClickListener {
            openCamera()
        }
    }

    private fun onClick() {
        val intent = Intent(applicationContext, MoveActivity::class.java)
        startActivity(intent)
    }
    private fun onDial() {
        val dialNumber = "088991228032"
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialNumber))
        startActivity(intent)
    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(takePictureIntent)

    }
}