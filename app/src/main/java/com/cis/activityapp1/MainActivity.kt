package com.cis.activityapp1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val SECOND_ACTIVITY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            val intent = Intent("com.test.second")
            intent.putExtra("data1", 100)
            intent.putExtra("data2", 11.11)
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var value1: Int? = 0
        var value2: Double? = 0.0

        if (resultCode == Activity.RESULT_OK) {
            value1 = data?.getIntExtra("value1", 0)
            value2 = data?.getDoubleExtra("value2", 0.0)

            app1MainTv.text = "result_ok 받은 value1 값 : ${value1}\n"
            app1MainTv.append("result_ok 받은 value2 값 : ${value2}")
        } else if (resultCode == Activity.RESULT_CANCELED) {
            value1 = data?.getIntExtra("value1", 0)
            value2 = data?.getDoubleExtra("value2", 0.0)

            app1MainTv.text = "result_cancle 받은 value1 값 : ${value1}\n"
            app1MainTv.append("result_cancle 받은 value2 값 : ${value2}")
        }
    }
}
