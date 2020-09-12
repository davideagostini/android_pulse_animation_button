package com.pulsebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var handlerAnimation = Handler()
    private var statusAnimation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (statusAnimation) {
                stopPulse()
                button.setText(R.string.start)
            }
            else {
                startPulse()
                button.setText(R.string.stop)
            }
            statusAnimation = !statusAnimation
        }
    }

    private fun startPulse() {
        runnable.run()
    }

    private fun stopPulse() {
        handlerAnimation.removeCallbacks(runnable)
    }

    private var runnable = object : Runnable {
        override fun run() {

            imgAnimation1.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000)
                    .withEndAction {
                        imgAnimation1.scaleX = 1f
                        imgAnimation1.scaleY = 1f
                        imgAnimation1.alpha = 1f
                    }

            imgAnimation2.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(700)
                .withEndAction {
                    imgAnimation2.scaleX = 1f
                    imgAnimation2.scaleY = 1f
                    imgAnimation2.alpha = 1f
                }

            handlerAnimation.postDelayed(this, 1500)
        }
    }
}