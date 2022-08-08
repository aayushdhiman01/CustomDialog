package com.aayush.customdialog

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var update:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        update=findViewById(R.id.btUpdate)
        update.setOnClickListener{
            val dialog=Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.customdialog)

            val update2=dialog.findViewById<Button>(R.id.btdUpdate2)
            update2.setOnClickListener{
                dialog.dismiss()
            }

            dialog.show()
           
        }
    }
}