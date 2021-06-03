package com.example.offloadingassigment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnFour: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne = findViewById(R.id.btn1)
        btnTwo = findViewById(R.id.btn2)
        btnThree = findViewById(R.id.btn3)
        btnFour = findViewById(R.id.btn4)


        btnOne.setOnClickListener {

            val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString(
                "video",
                "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
            )
            editor.apply()

            val i = Intent(this, PlayerAcitivity::class.java)
            startActivity(i)

        }


        btnTwo.setOnClickListener {

            val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("video", "https://bestvpn.org/html5demos/assets/dizzy.mp4")
            editor.apply()

            val i = Intent(this, PlayerAcitivity::class.java)
            startActivity(i)

        }
        btnThree.setOnClickListener {

            val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString(
                "video",
                "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"
            )
            editor.apply()

            val i = Intent(this, PlayerAcitivity::class.java)
            startActivity(i)

        }
        btnFour.setOnClickListener {

            val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString(
                "video",
                "https://bestvpn.org/html5demos/assets/dizzy.mp4"
            )
            editor.apply()

            val i = Intent(this, PlayerAcitivity::class.java)
            startActivity(i)

        }


    }

}

