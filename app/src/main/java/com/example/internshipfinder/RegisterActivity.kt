package com.example.internshipfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.internshipfinder.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.registerBtn.setOnClickListener {
            val uname = binding.nameEt.text.toString()
            val Uemail = binding.emailEt.text.toString()
            val UPassword = binding.passwordEt.text.toString()


            if (uname.isEmpty() || Uemail.isEmpty() || UPassword.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(Uemail, UPassword)

                .addOnSuccessListener {
                    val userID = auth.currentUser!!.uid

                    val usermap = hashMapOf(
                        "name" to uname,
                        "Email" to Uemail
                    )

                    db.collection("user")
                        .document(userID)
                        .set(usermap)

                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }
        binding.loginTxt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
    }
}