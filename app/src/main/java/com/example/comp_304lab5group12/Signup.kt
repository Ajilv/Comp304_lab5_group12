package com.example.comp_304lab5group12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {

    private lateinit var authenticate : FirebaseAuth
    private lateinit var etemail : EditText
    private lateinit var etPassword : EditText
    private lateinit var signUpBtn : Button

    private val tag  = "Firebase_Auth_SignUp"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        etemail = findViewById(R.id.editTextTextPersonName3)
        etPassword = findViewById(R.id.editTextTextPersonName4)
        signUpBtn = findViewById(R.id.signupBtn)

        signUpBtn.setOnClickListener{


        }



    }

    fun CreateUser(){
        val email = etemail.text.toString()
        val password = etPassword.text.toString()

        if(TextUtils.isEmpty(email)){
            etemail.error = "This field can not be empty"
            etemail.requestFocus()
        } else if (TextUtils.isEmpty(password)){
            etPassword.error = "This field can not be empty"

        } else{
            authenticate.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {
                        task -> if(task.isSuccessful){
                    Toast.makeText(this@Signup,"Sign up successful",Toast.LENGTH_SHORT).show()


                    val intent = Intent(this@Signup,MainActivity::class.java)
                    startActivity(intent)
                } else{

                    Toast.makeText(baseContext,"Authentication failed",Toast.LENGTH_SHORT).show()
                }
                }
        }



    }

















}