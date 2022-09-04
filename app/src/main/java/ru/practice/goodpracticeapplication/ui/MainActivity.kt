package ru.practice.goodpracticeapplication.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.practice.goodpracticeapplication.R
import ru.practice.goodpracticeapplication.utils.livedata.ConnectionLiveData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkStatusTextView = findViewById<TextView>(R.id.network_status)

        val connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this) { isNetworkAvailable ->
            if (isNetworkAvailable) {
                networkStatusTextView.apply {
                    text = getString(R.string.connection_is_available)
                    setBackgroundColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.light_green
                        )
                    )
                }
            } else {
                networkStatusTextView.apply {
                    text = getString(R.string.connection_is_lost)
                    setBackgroundColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.black
                        )
                    )
                }
            }
        }
    }
}