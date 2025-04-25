package com.example.empfirebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.empfirebase.databinding.ActivityGetEmpDataBinding
import com.google.firebase.database.FirebaseDatabase

class GetEmpDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetEmpDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityGetEmpDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetData.setOnClickListener {
            getData(binding.edtEId.text.toString())
        }

        binding.btnUpdate.setOnClickListener {
            updateData()
        }

        binding.btnDelete.setOnClickListener {
            deleteData()
        }
    }

    private fun getData(id: String) {
        val database = FirebaseDatabase.getInstance().getReference("EmpData1")

        database.child(id).get().addOnSuccessListener {
            if (it.exists()) {
                val data = it.getValue(EmpData::class.java)

                binding.edtEId.setText(data?.empID)
                binding.edtEFName.setText(data?.eFname)
                binding.edtELName.setText(data?.eLname)
                binding.edtEId.isEnabled = false

            } else {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Data Fetching Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateData() {
        val database = FirebaseDatabase.getInstance().getReference("EmpData1")

        val eid = binding.edtEId.text.toString()
        val fname = binding.edtEFName.text.toString()
        val lname = binding.edtELName.text.toString()

        val updatedData = EmpData(eid, fname, lname)

        database.child(eid).setValue(updatedData).addOnSuccessListener {
            Toast.makeText(this, "Data Updated!", Toast.LENGTH_LONG).show()
            clearFields()
        }.addOnFailureListener {
            Toast.makeText(this, "Data Not Updated!", Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteData() {
        val database = FirebaseDatabase.getInstance().getReference("EmpData1")

        database.child(binding.edtEId.text.toString()).removeValue().addOnSuccessListener {
            Toast.makeText(this, "Data Deleted!", Toast.LENGTH_LONG).show()
            clearFields()
        }.addOnFailureListener {
            Toast.makeText(this, "Data Not Deleted!", Toast.LENGTH_LONG).show()
        }
    }

    private fun clearFields() {
        binding.edtEId.setText("")
        binding.edtEFName.setText("")
        binding.edtELName.setText("")
        binding.edtEId.isEnabled = true
    }
}
