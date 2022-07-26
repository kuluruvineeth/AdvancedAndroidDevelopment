package com.kuluruvineeth.databindingwithobjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kuluruvineeth.databindingwithobjects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.student = getStudent()
        /*val student = getStudent()
        binding.apply {
            nameText.text = student.name
            emailText.text = student.email
        }*/
    }
    private fun getStudent():Student{
        return Student(1,"Vineeth","Vineeth@gmail.com")
    }
}