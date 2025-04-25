package com.example.animation

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.databinding.ActivityMainBinding

class AnimDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRotate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
            binding.txtDemo.startAnimation(animation)
        }

        binding.btnAlpha.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
            binding.txtDemo.startAnimation(animation)
        }

        binding.btnTranslate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.translate)
            binding.txtDemo.startAnimation(animation)
        }
    }
}
