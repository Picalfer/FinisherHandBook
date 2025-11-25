package com.example.finisherhandbook

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        var tvTitle: TextView? = findViewById(R.id.tvTitle2)
        var tvContent: TextView? = findViewById(R.id.textView3)
        var im: ImageView? = findViewById(R.id.im2)

        tvTitle?.text = intent.getStringExtra("title")
        tvContent?.text = intent.getStringExtra("content")
        im?.setImageResource(intent.getIntExtra("image", R.drawable.som))
    }
}