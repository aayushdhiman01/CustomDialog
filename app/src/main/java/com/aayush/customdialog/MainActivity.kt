package com.aayush.customdialog

import android.app.Dialog
import android.os.Bundle

import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity
import com.aayush.customdialog.databinding.ActivityMainBinding
import com.aayush.customdialog.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var update:Button
    lateinit var Name:EditText
    lateinit var Address:EditText
    lateinit var Gender:EditText
    lateinit var Specify:EditText
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Name=findViewById(R.id.etName)
        Address=findViewById(R.id.etAddress)
        Gender=findViewById(R.id.etGender)
        Specify=findViewById(R.id.etOtherSpecify)

        update=findViewById(R.id.btUpdate)
        update.setOnClickListener{
            var dialogBinding = CustomdialogBinding.inflate(layoutInflater)
            val dialog=Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(dialogBinding.root)
//            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            val update2=dialog.findViewById<Button>(R.id.btdUpdate2)
            if(binding.etGender.text.toString().equals("Male")) {
                dialogBinding.rbdMale.isChecked=true
            }
            else if(binding.etGender.text.toString().equals("Female")) {
                dialogBinding.rbdFemale.isChecked=true
            }
            else if(binding.etGender.text.toString().equals("Other")) {
                dialogBinding.rbdOther.isChecked=true
            }
            update2.setOnClickListener{
                binding.etName.setText(dialogBinding.etdName.text.toString())
                binding.etAddress.setText(dialogBinding.etdAddress.text.toString())
                when(dialogBinding.rgdGender.id){
                    R.id.rbdMale-> binding.tvGender.setText("Male")
                    R.id.rbdFemale-> binding.tvGender.setText("Female")
                    R.id.rbdOther-> binding.tvGender.setText("Other")
                }
                dialog.dismiss()
            }
            dialog.show()
        }




    }
}