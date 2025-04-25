package com.example.empfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.empfirebase.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsertData.setOnClickListener {
            setData()
        }

        binding.btnGetData.setOnClickListener {
            startActivity(Intent(this,GetEmpDataActivity::class.java))
        }
    }


    fun setData()
    {
        var database  = FirebaseDatabase.getInstance()
            .getReference("EmpData1")

        var id = binding.edtEId.text.toString()
        var fname = binding.edtEFName.text.toString()
        var lname = binding.edtELName.text.toString()

        var empdata = EmpData(id,fname,lname)

        database.child(id).setValue(empdata).addOnSuccessListener {
            Toast.makeText(this,"Data Inserted",Toast.LENGTH_LONG).show()

            binding.edtEId.setText("")
            binding.edtEFName.setText("")
            binding.edtELName.setText("")

        }.addOnFailureListener {
            Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_LONG).show()
        }
    }




}






